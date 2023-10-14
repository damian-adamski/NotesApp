package com.da.whatstodo.featureNote.domain.useCase

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.model.exception.InvalidNoteException
import com.da.whatstodo.featureNote.domain.repository.NoteRepository

class AddNoteUseCase(
    private val noteRepository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) throw InvalidNoteException.EmptyTitleException
        if (note.content.isBlank()) throw InvalidNoteException.EmptyContentException

        noteRepository.insertNote(note)
    }
}