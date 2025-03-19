package com.zybooks.habit

import androidx.lifecycle.viewmodel.compose.viewModel
import com.zybooks.habit.viewmodel.HomeViewModel
import com.zybooks.habit.viewmodel.AddEditHabitViewModel
import com.zybooks.habit.viewmodel.SettingsViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier


@Composable
fun HabitTrackerApp(modifier: Modifier = Modifier) {
    var screen by remember { mutableStateOf("Home") }

    when (screen) {
        "Home" -> {
            val homeViewModel: HomeViewModel = viewModel()
            HomeScreen(homeViewModel) { screen = it }
        }
        "AddHabit" -> {
            val addEditHabitViewModel: AddEditHabitViewModel = viewModel()
            AddEditHabitScreen(addEditHabitViewModel) { screen = "Home" }
        }
        "Settings" -> {
            val settingsViewModel: SettingsViewModel = viewModel()
            SettingsScreen(settingsViewModel) { screen = "Home" }
        }
    }
}