package com.da.whatstodo.featureNote.domain.useCase

import com.da.whatstodo.featureNote.domain.model.Note
import com.da.whatstodo.featureNote.domain.repository.NoteRepository
import com.da.whatstodo.featureNote.domain.util.NoteOrder
import com.da.whatstodo.featureNote.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val noteRepository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return noteRepository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.date }
                        is NoteOrder.Priority -> notes.sortedBy { it.priority.importanceLevel }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.date }
                        is NoteOrder.Priority -> notes.sortedByDescending { it.priority.importanceLevel }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}