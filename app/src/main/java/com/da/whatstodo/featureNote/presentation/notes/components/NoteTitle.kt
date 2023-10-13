package com.da.whatstodo.featureNote.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.da.whatstodo.R
import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.util.NotePriority
import com.da.whatstodo.ui.theme.Colors
import java.time.OffsetDateTime

@Composable
fun NoteTitle(
    note: Note,
    maxLines: Int = 2,
    isShowPriority: Boolean = true
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (isShowPriority) {
            Box {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    painter = painterResource(
                        id = R.drawable.ic_priority_24),
                    tint = Color.Black,
                    contentDescription = note.priority.name
                )
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center),
                            painter = painterResource(
                            id = R.drawable.ic_priority_24),
                    tint = Color(note.color),
                    contentDescription = note.priority.name
                )
            }
        }
        Text(
            text = note.title,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.onSurface,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteTitlePreview() {
    NoteTitle(note = Note(
        title = "tritani",
        content = "menandri",
        date = OffsetDateTime.now(),
        color = Colors.NoteColors.OceanBlue.toArgb(),
        priority = NotePriority.Medium,
        id = null
    ))
}