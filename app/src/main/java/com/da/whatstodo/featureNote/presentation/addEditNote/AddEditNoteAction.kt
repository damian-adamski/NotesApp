package com.da.whatstodo.featureNote.presentation.addEditNote

import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color

/**
 * Named it AddEditNoteAction, because `Event` had to be used
 * for actual UI event.
 */
sealed class AddEditNoteAction {
    data class TitleChange(val title: String) : AddEditNoteAction()
    data class ContentChange(val content: String) : AddEditNoteAction()
    data class TitleFocusChange(val focusState: FocusState) : AddEditNoteAction()
    data class ContentFocusChange(val focusState: FocusState) : AddEditNoteAction()
    data class ColorChange(val color: Color) : AddEditNoteAction()
    object SaveNote : AddEditNoteAction()
}
