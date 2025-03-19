package com.zybooks.habit

import androidx.lifecycle.viewmodel.compose.viewModel
import com.zybooks.habit.viewmodel.HomeViewModel
import com.zybooks.habit.viewmodel.AddEditHabitViewModel
import com.zybooks.habit.viewmodel.SettingsViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.zybooks.habit.ui.AddHabitScreen
import com.zybooks.habit.ui.EditHabitScreen


@Composable
fun HabitTrackerApp(modifier: Modifier = Modifier) {
    var screen by remember { mutableStateOf("Home") }
    var selectedHabit by remember { mutableStateOf("") }

    val homeViewModel: HomeViewModel = viewModel()
    val addEditHabitViewModel: AddEditHabitViewModel = viewModel()
    val settingsViewModel: SettingsViewModel = viewModel()

    when (screen) {
        "Home" -> HomeScreen(homeViewModel) { newScreen, habit ->
            selectedHabit = habit ?: ""
            screen = newScreen
        }
        "AddHabit" -> AddHabitScreen(homeViewModel) { screen = "Home" }
        "EditHabit" -> EditHabitScreen(addEditHabitViewModel, homeViewModel, selectedHabit) { screen = "Home" }
        "Settings" -> SettingsScreen(settingsViewModel) { screen = "Home" }
    }
}
