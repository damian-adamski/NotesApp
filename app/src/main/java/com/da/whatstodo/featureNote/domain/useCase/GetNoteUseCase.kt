package com.da.whatstodo.featureNote.domain.useCase

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.repository.NoteRepository

class GetNoteUseCase(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return noteRepository.getNoteById(id)
    }
}