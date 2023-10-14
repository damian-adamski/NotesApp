package com.da.whatstodo.featureNote.presentation.util

import com.da.whatstodo.util.ToBeRefactored

@ToBeRefactored(
    "I would like to pass hint in UI not in ViewModel" +
            "I need to think of workaround"
)
data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
