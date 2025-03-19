package com.zybooks.habit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zybooks.habit.viewmodel.SettingsViewModel


@Composable
fun SettingsScreen(viewModel: SettingsViewModel, onBack: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Settings", style = MaterialTheme.typography.headlineSmall)
        Row(modifier = Modifier.padding(8.dp)) {
            Text("Enable Notifications")
            Switch(checked = viewModel.notificationsEnabled, onCheckedChange = { viewModel.notificationsEnabled = it })
        }
        Button(onClick = { onBack() }) {
            Text("Save")
        }
    }
}
