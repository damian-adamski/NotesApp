package com.da.whatstodo.featureNote.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.da.whatstodo.featureNote.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DatabaseName = "notes_db"
    }
}