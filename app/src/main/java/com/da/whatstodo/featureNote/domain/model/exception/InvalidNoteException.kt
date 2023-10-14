package com.da.whatstodo.featureNote.domain.model.exception

sealed class InvalidNoteException : Exception() {
    object EmptyTitleException : InvalidNoteException()
    object EmptyContentException : InvalidNoteException()
}