package com.da.whatstodo.featureNote.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.useCase.NoteUseCases
import com.da.whatstodo.featureNote.domain.util.NoteOrder
import com.da.whatstodo.featureNote.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var getNotesJob: Job? = null

    private var recentlyDeletedNote: Note? = null

    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.ChangeOrder -> handleOrderNotes(event.noteOrder)
            is NotesEvent.DeleteNote -> handleDeleteNote(event.note)
            NotesEvent.RestoreNote -> handleRestoreNote()
            NotesEvent.ToggleOrderSection -> handleToggleEvent()
        }
    }

    private fun handleOrderNotes(noteOrder: NoteOrder) {
        if (
            state.value.noteOrder::class == noteOrder::class &&
            state.value.noteOrder.orderType == noteOrder.orderType
        ) return

        getNotes(noteOrder)
    }

    private fun handleRestoreNote() {
        viewModelScope.launch {
            useCases.addNote(recentlyDeletedNote ?: return@launch)
            recentlyDeletedNote = null
        }
    }

    private fun handleDeleteNote(note: Note) {
        viewModelScope.launch {
            useCases.deleteNote(note)
        }
    }

    private fun handleToggleEvent() {
        _state.value = state.value.copy(
            isOrderSectionVisible = !state.value.isOrderSectionVisible
        )
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = viewModelScope.launch {
            useCases.getNotes(noteOrder)
                .onEach { notes ->
                    _state.value = state.value.copy(
                        notes = notes,
                        noteOrder = noteOrder
                    )
                }
                .launchIn(viewModelScope)
        }
    }
}