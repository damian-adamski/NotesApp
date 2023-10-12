package com.da.whatstodo.featureNote.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.da.whatstodo.featureNote.domain.util.NotePriority
import com.da.whatstodo.ui.theme.Colors
import java.time.OffsetDateTime

@Entity
data class Note(
    val title: String,
    val content: String,
    val date: OffsetDateTime,
    val color: Int,
    val priority: NotePriority,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = Colors.NoteColors.run {
            listOf(
                RedOrange,
                OceanBlue,
                LightPurple,
                LightGreen,
                RedPink
            )
        }
    }
}
