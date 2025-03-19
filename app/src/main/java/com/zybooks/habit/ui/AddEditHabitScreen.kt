package com.zybooks.habit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.habit.viewmodel.AddEditHabitViewModel


@Composable
fun AddEditHabitScreen(viewModel: AddEditHabitViewModel, onSave: () -> Unit) {
    var habitName by remember { mutableStateOf(viewModel.habitName) }
    var frequency by remember { mutableStateOf("Daily") }
    var startDate by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Add/Edit Habit", fontSize = 24.sp, style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Habit Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Frequency: $frequency")

        // pick date
        OutlinedButton(onClick = { /* Implement Date Picker */ }) {
            Text("Select Start Date")
        }

        // Save Button
        Button(
            onClick = {
                viewModel.habitName = habitName
                onSave()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}
