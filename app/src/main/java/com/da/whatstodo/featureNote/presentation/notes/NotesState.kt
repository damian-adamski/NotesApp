package com.da.whatstodo.featureNote.presentation.notes

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.util.NoteOrder
import com.da.whatstodo.featureNote.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
