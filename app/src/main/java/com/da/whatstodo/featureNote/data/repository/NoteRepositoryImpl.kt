package com.da.whatstodo.featureNote.data.repository

import com.da.whatstodo.featureNote.data.mappers.mapToDomain
import com.da.whatstodo.featureNote.data.mappers.mapToDto
import com.da.whatstodo.featureNote.data.model.NoteDto
import com.da.whatstodo.featureNote.data.source.NoteDao
import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes().map { list ->
            list.map { it.mapToDomain() }
        }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.mapToDomain()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.mapToDto())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.mapToDto())
    }
}