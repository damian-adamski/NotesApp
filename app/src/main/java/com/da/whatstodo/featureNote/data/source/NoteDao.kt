package com.da.whatstodo.featureNote.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.da.whatstodo.featureNote.data.model.NoteDto
import com.da.whatstodo.featureNote.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteDto")
    fun getNotes(): Flow<List<NoteDto>>

    @Query("SELECT * FROM noteDto WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteDto?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteDto)

    @Delete
    suspend fun deleteNote(note: NoteDto)
}