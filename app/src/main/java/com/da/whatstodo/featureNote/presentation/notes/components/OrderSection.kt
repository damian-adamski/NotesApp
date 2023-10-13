package com.da.whatstodo.featureNote.presentation.notes.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.da.whatstodo.featureNote.domain.util.NoteOrder
import com.da.whatstodo.featureNote.domain.util.OrderType
import com.da.whatstodo.util.ToBeImplemented

@ToBeImplemented(
    what = "String resources",
    time = "After app core is finished"
)
@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DefaultRadioButton(
                text = "Title",
                isSelected = noteOrder is NoteOrder.Title,
                onSelect = {
                    onOrderChange(NoteOrder.Title(noteOrder.orderType))
                }
            )
            DefaultRadioButton(
                text = "Date",
                isSelected = noteOrder is NoteOrder.Date,
                onSelect = {
                    onOrderChange(NoteOrder.Date(noteOrder.orderType))
                }
            )
            DefaultRadioButton(
                text = "Priority",
                isSelected = noteOrder is NoteOrder.Priority,
                onSelect = {
                    onOrderChange(NoteOrder.Priority(noteOrder.orderType))
                }
            )
            DefaultRadioButton(
                text = "Color",
                isSelected = noteOrder is NoteOrder.Color,
                onSelect = {
                    onOrderChange(NoteOrder.Color(noteOrder.orderType))
                }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Descending",
                isSelected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    val descendingOrder = noteOrder.copy(OrderType.Descending)
                    onOrderChange(descendingOrder)
                }
            )
            DefaultRadioButton(
                text = "Ascending",
                isSelected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    val ascendingOrder = noteOrder.copy(OrderType.Ascending)
                    onOrderChange(ascendingOrder)
                }
            )
        }
    }
}