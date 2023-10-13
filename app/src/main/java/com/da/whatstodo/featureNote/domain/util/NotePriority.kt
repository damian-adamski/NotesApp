package com.da.whatstodo.featureNote.domain.util

import androidx.compose.ui.graphics.Color
import com.da.whatstodo.ui.theme.Colors

enum class NotePriority(
    val importanceLevel: Int,
    val color: Color,
) {
    Low(1, Colors.Priority.Low),
    Medium(2, Colors.Priority.Medium),
    High(3, Colors.Priority.High)
}