package com.da.whatstodo.featureNote.presentation.addEditNote

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.useCase.NoteUseCases
import com.da.whatstodo.featureNote.domain.util.NotePriority
import com.da.whatstodo.ui.theme.Colors
import dagger.hilt.android.lifecycle.HiltViewModel
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
    private val _noteTitle = mutableStateOf("")
    val noteTitle: State<String> = _noteTitle

    private val _noteContent = mutableStateOf("")
    val noteContent: State<String> = _noteContent

    private val _notePriority = mutableStateOf(NotePriority.Low)
    val notePriority: State<NotePriority> = _notePriority

    private val _noteColor = mutableStateOf(Note.noteColors.first())
    val noteColor: State<Color> = _noteColor
}