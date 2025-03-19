package com.zybooks.habit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.habit.viewmodel.HomeViewModel


@Composable
fun HomeScreen(viewModel: HomeViewModel, onNavigate: (String, String?) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Habit Tracker", style = MaterialTheme.typography.headlineMedium)

        // List of habits
        for (habit in viewModel.habits) {
            Text(
                text = habit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onNavigate("EditHabit", habit) } // ✅ Navigate to EditHabit
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Floating Action Button to Add New Habit
        FloatingActionButton(
            onClick = { onNavigate("AddHabit", null) }, // ✅ Navigate to AddHabit
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("+")
        }
    }
}

@Composable
fun HabitItem(habit: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(habit, fontSize = 18.sp)
    }
}
