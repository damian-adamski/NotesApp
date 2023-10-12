package com.da.whatstodo.featureNote.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
