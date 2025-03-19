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
fun HomeScreen(viewModel: HomeViewModel, navigate: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Habit Tracker",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // List of habits
        viewModel.habits.forEach { habit ->
            HabitItem(habit = habit, onClick = { navigate("AddHabit") })
        }

        Spacer(modifier = Modifier.weight(1f))

        // Add Button
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                .align(Alignment.CenterHorizontally)
                .clickable { navigate("AddHabit") },
            contentAlignment = Alignment.Center
        ) {
            Text("+", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
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
