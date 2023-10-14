package com.da.whatstodo.featureNote.presentation.addEditNote

import com.da.whatstodo.featureNote.domain.model.exception.InvalidNoteException

sealed class AddEditNoteEvent {
    data class ShowError(val exception: InvalidNoteException) : AddEditNoteEvent()
    object SaveNote: AddEditNoteEvent()
}
