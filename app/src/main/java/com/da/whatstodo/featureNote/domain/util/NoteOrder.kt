package com.da.whatstodo.featureNote.domain.util

/**
 * If I would use data classes I couldn't copy value without knowing
 * exact type of subclass anyway, so I prefer to create my own `copy()` method instead
 */
sealed class NoteOrder(val orderType: OrderType) {
    class Title(orderType: OrderType): NoteOrder(orderType)
    class Date(orderType: OrderType): NoteOrder(orderType)
    class Priority(orderType: OrderType): NoteOrder(orderType)
    class Color(orderType: OrderType): NoteOrder(orderType)

    fun copy(orderType: OrderType): NoteOrder {
        return when(this) {
            is Color -> Color(orderType)
            is Date -> Date(orderType)
            is Priority -> Priority(orderType)
            is Title -> Title(orderType)
        }
    }
}