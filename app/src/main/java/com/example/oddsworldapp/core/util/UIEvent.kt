package com.example.oddsworldapp.core.util
    sealed class UIEvent{
        data class ShowSnackBar(val message: String): UIEvent()
    }