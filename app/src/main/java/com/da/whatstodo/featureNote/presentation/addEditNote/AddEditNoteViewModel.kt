package com.da.whatstodo.featureNote.presentation.addEditNote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.model.exception.InvalidNoteException
import com.da.whatstodo.featureNote.domain.useCase.NoteUseCases
import com.da.whatstodo.featureNote.domain.util.NotePriority
import com.da.whatstodo.featureNote.presentation.util.NoteTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.time.OffsetDateTime
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {

    /**
     * Using separate states for each field to optimize recomposition.
     * With single state while inserting characters to one TextField
     * the whole screen would be recomposed.
     * Keeping it separate will allow to recompose only TextField's
     * that need to be recomposed.
     */
    private val _noteTitle = mutableStateOf(NoteTextFieldState(
        hint = "Enter title"
    ))
    val noteTitle: State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState(
        hint = "Enter some content"
    ))
    val noteContent: State<NoteTextFieldState> = _noteContent

    private val _notePriority = mutableStateOf(NotePriority.Low)
    val notePriority: State<NotePriority> = _notePriority

    private val _noteColor = mutableStateOf(Note.noteColors.first())
    val noteColor: State<Color> = _noteColor

    private val _eventFlow = MutableSharedFlow<AddEditNoteEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onAction(action: AddEditNoteAction) {
        when(action) {
            is AddEditNoteAction.ColorChange -> handleColorChanged(action.color)
            is AddEditNoteAction.ContentChange -> handleContentChanged(action.content)
            is AddEditNoteAction.ContentFocusChange -> handleContentFocusChanged(action.focusState)
            is AddEditNoteAction.TitleChange -> handleTitleChanged(action.title)
            is AddEditNoteAction.TitleFocusChange -> handleTitleFocusChanged(action.focusState)
            AddEditNoteAction.SaveNote -> handleNoteSaved()
        }
    }

    private fun handleNoteSaved() {
        viewModelScope.launch {
            val note = Note(
                title = noteTitle.value.text,
                content = noteContent.value.text,
                date = OffsetDateTime.now(),
                color = noteColor.value.toArgb(),
                priority = notePriority.value,
            )

            try {
                useCases.addNote(note)

                _eventFlow.tryEmit(
                    AddEditNoteEvent.SaveNote
                )
            } catch (ex: InvalidNoteException) {
                _eventFlow
                    .tryEmit(
                        AddEditNoteEvent.ShowError(ex)
                    )
            }
        }
    }

    private fun handleTitleFocusChanged(focusState: FocusState) {
        _noteTitle.value = noteTitle.value.copy(
            isHintVisible = !focusState.isFocused &&
                    noteTitle.value.text.isBlank()
        )
    }

    private fun handleContentFocusChanged(focusState: FocusState) {
        _noteContent.value = noteContent.value.copy(
            isHintVisible = !focusState.isFocused &&
                    noteContent.value.text.isBlank()
        )
    }

    private fun handleColorChanged(color: Color) {
        _noteColor.value = color
    }

    private fun handleContentChanged(content: String) {
        _noteContent.value = noteContent.value.copy(
            text = content
        )
    }

    private fun handleTitleChanged(title: String) {
        _noteTitle.value = noteTitle.value.copy(
            text = title
        )
    }

}