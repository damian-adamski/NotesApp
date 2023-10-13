package com.da.whatstodo.featureNote.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.da.whatstodo.featureNote.domain.util.NotePriority

@Entity
data class NoteDto(
    val title: String,
    val content: String,
    val date: String,
    val color: Int,
    val priority: NotePriority,
    @PrimaryKey val id: Int? = null
)