package com.zybooks.habit.ui

import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.habit.viewmodel.SettingsViewModel
import java.util.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen(viewModel: SettingsViewModel, onBack: () -> Unit) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var reminderTime by remember { mutableStateOf(viewModel.reminderTime) } // Get from ViewModel

    // Time Picker Dialog
    val timePickerDialog = TimePickerDialog(
        context,
        { _: TimePicker, hour: Int, minute: Int ->
            val formattedHour = if (hour == 0) 12 else if (hour > 12) hour - 12 else hour
            val amPm = if (hour >= 12) "PM" else "AM"
            val formattedTime = String.format("%02d:%02d %s", formattedHour, minute, amPm)

            // Update the ViewModel and UI state
            reminderTime = formattedTime
            viewModel.reminderTime = formattedTime
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        false
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings",
            fontSize = 24.sp,
            style = MaterialTheme.typography.headlineSmall
        )

        // Notifications
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Enable Notifications", modifier = Modifier.weight(1f))
            Switch(
                checked = viewModel.notificationsEnabled,
                onCheckedChange = { viewModel.notificationsEnabled = it }
            )
        }

        // Reminder Time
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Text("Reminder Time", modifier = Modifier.weight(1f))
            Button(onClick = { timePickerDialog.show() }) {
                Text(reminderTime, color = Color.White)
            }
        }

        // Save Button
        Button(
            onClick = { onBack() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Save")
        }
    }
}
