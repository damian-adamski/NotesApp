package com.da.whatstodo.featureNote.presentation.notes

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
