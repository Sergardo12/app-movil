package com.example.my_app_project.utils

import androidx.navigation.NavController

fun NavController.safeNavigate(destinationId: Int) {
    if (currentDestination?.id != destinationId) {
        navigate(destinationId)
    }
}