package com.zybooks.habit

import androidx.lifecycle.viewmodel.compose.viewModel
import com.zybooks.habit.viewmodel.HomeViewModel
import com.zybooks.habit.viewmodel.SettingsViewModel
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.zybooks.habit.ui.AddHabitScreen
import com.zybooks.habit.ui.EditHabitScreen
import com.zybooks.habit.ui.HomeScreen
import com.zybooks.habit.ui.SettingsScreen

@Composable
fun HabitTrackerApp(modifier: Modifier = Modifier) {
    var screen by remember { mutableStateOf("Home") }
    var selectedHabitIndex by remember { mutableStateOf<Int?>(null) }

    val homeViewModel: HomeViewModel = viewModel()
    val settingsViewModel: SettingsViewModel = viewModel()

    when (screen) {
        "Home" -> HomeScreen(homeViewModel) { destination, index ->
            selectedHabitIndex = index
            screen = destination
        }
        "AddHabit" -> AddHabitScreen(homeViewModel) { screen = "Home" }
        "EditHabit" -> {
            selectedHabitIndex?.let { index ->
                EditHabitScreen(homeViewModel, index) { screen = "Home" }
            }
        }
        "Settings" -> SettingsScreen(settingsViewModel) { screen = "Home" }
    }
}
