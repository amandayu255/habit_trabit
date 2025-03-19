package com.zybooks.habit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zybooks.habit.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel, onNavigate: (String, Int?) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Habit Tracker", style = MaterialTheme.typography.headlineMedium)

        viewModel.habits.forEachIndexed { index, habit ->
            Button(
                onClick = { onNavigate("EditHabit", index) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
            ) {
                Text(habit)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        FloatingActionButton(
            onClick = { onNavigate("AddHabit", null) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("+", style = MaterialTheme.typography.headlineSmall)
        }
    }
}
