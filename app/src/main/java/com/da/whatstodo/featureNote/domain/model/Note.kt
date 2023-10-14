package com.da.whatstodo.featureNote.domain.model

import com.da.whatstodo.featureNote.domain.util.NotePriority
import com.da.whatstodo.ui.theme.Colors
import java.time.OffsetDateTime

data class Note(
    val title: String,
    val content: String,
    val date: OffsetDateTime,
    val color: Int,
    val priority: NotePriority,
    val id: Int? = null
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
