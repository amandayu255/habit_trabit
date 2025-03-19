package com.zybooks.habit.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.habit.viewmodel.AddEditHabitViewModel
import com.zybooks.habit.viewmodel.HomeViewModel

@Composable
fun EditHabitScreen(
    viewModel: AddEditHabitViewModel,
    homeViewModel: HomeViewModel,
    originalHabit: String,
    onSave: () -> Unit
) {
    var habitName by remember { mutableStateOf(originalHabit) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Edit Habit", fontSize = 24.sp, style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Habit Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Save Button
        Button(
            onClick = {
                if (habitName.isNotBlank()) {
                    homeViewModel.updateHabit(originalHabit, habitName)
                }
                onSave()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}
