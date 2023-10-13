package com.da.whatstodo.featureNote.data.mappers

import com.da.whatstodo.featureNote.data.model.NoteDto
import com.da.whatstodo.featureNote.domain.model.Note
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun NoteDto.mapToDomain(): Note {
    return Note(
        title = title,
        content = content,
        date = date.toOffsetDateTime(),
        color = color,
        priority = priority,
        id = id
    )
}

fun Note.mapToDto(): NoteDto {
    return NoteDto(
        title = title,
        content = content,
        date = date.parseToString(),
        color = color,
        priority = priority,
        id = id
    )
}


/**
 * These are not for outside use so it is better to keep
 * them here private.
 */
private fun OffsetDateTime.parseToString(): String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    return format(formatter)
}

private fun String.toOffsetDateTime(): OffsetDateTime {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    return OffsetDateTime.parse(this, formatter)
}