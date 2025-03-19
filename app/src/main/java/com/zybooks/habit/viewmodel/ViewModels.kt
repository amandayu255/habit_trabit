package com.zybooks.habit.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var habits = mutableStateListOf("Drink water", "Charge phone", "Bring water bottle")
}

class AddEditHabitViewModel : ViewModel() {
    var habitName by mutableStateOf("")
}

class SettingsViewModel : ViewModel() {
    var notificationsEnabled by mutableStateOf(false)
}