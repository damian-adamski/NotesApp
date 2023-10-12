package com.da.whatstodo.featureNote.presentation.notes

import androidx.lifecycle.ViewModel
import com.da.whatstodo.featureNote.domain.useCase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val useCases: NoteUseCases
) : ViewModel() {


}