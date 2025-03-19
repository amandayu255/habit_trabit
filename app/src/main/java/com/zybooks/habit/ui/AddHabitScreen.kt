package com.zybooks.habit.ui

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.habit.viewmodel.HomeViewModel
import java.util.*

@Composable
fun AddHabitScreen(
    homeViewModel: HomeViewModel,
    onSave: () -> Unit
) {
    var habitName by remember { mutableStateOf("") }
    var frequency by remember { mutableStateOf("Daily") }
    var startDate by remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    // Date Picker
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            startDate = "$day/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Add Habit", fontSize = 24.sp, style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Habit Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Frequency Dropdown
        var expanded by remember { mutableStateOf(false) }
        Box {
            OutlinedTextField(
                value = frequency,
                onValueChange = {},
                label = { Text("Frequency") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("Daily", "Weekly", "Biweekly", "Monthly").forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            frequency = option
                            expanded = false
                        }
                    )
                }
            }
        }

        // pick date
        OutlinedButton(
            onClick = { datePickerDialog.show() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (startDate.isEmpty()) "Select Start Date" else startDate)
        }

        // Save Button
        Button(
            onClick = {
                if (habitName.isNotBlank()) {
                    homeViewModel.addHabit(habitName)
                }
                onSave()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}
