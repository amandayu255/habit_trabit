package com.zybooks.habit.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var habits = mutableStateListOf("Drink water", "Charge phone", "Bring water bottle")

    fun addHabit(newHabit: String) {
        habits.add(newHabit)
    }

    fun updateHabit(oldHabit: String, newHabit: String) {
        val index = habits.indexOf(oldHabit)
        if (index != -1) {
            habits[index] = newHabit
        }
    }
}

class AddEditHabitViewModel : ViewModel() {
    var habitName = mutableStateOf("")
}

class SettingsViewModel : ViewModel() {
    var notificationsEnabled by mutableStateOf(false)
}