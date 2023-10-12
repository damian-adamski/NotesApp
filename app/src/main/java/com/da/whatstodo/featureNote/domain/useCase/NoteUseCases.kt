package com.da.whatstodo.featureNote.domain.useCase

import com.da.whatstodo.util.ToBeImplemented

/**
 * Class for aggregating all UseCase's for Note's main screen.
 */
@ToBeImplemented(
    what = "SearchNoteUseCase",
    time = "after app core is finished"
)
data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase
)
