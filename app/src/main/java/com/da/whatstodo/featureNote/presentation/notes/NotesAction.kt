package com.da.whatstodo.featureNote.presentation.notes

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.util.NoteOrder

/**
 * Renamed it for consistency with AddEditNote.
 * @see AddEditNoteAction
 */
sealed class NotesAction {
    data class ChangeOrder(val noteOrder: NoteOrder): NotesAction()
    data class DeleteNote(val note: Note): NotesAction()
    object RestoreNote: NotesAction()
    object ToggleOrderSection: NotesAction()
}
