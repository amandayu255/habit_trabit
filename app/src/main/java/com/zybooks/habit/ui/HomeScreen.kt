package com.zybooks.habit.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zybooks.habit.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel, onNavigate: (String, Int?) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Habit Trabit", style = MaterialTheme.typography.headlineMedium)

        for ((index, habit) in viewModel.habits.withIndex()) {
            Button(
                onClick = { onNavigate("EditHabit", index) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text(habit)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { onNavigate("Settings", null) },
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text("Settings")
            }

            // Floating button to add a new habit
            FloatingActionButton(
                onClick = { onNavigate("AddHabit", null) },
                modifier = Modifier.weight(1f)
            ) {
                Text("+", style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}
