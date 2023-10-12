package com.da.whatstodo.featureNote.domain.useCase

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.repository.NoteRepository

class DeleteNoteUseCase(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        noteRepository.deleteNote(note)
    }
}