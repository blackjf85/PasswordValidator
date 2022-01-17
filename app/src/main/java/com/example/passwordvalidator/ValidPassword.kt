package com.example.passwordvalidator

data class ValidPassword(
    val validLength: Boolean = false,
    val hasCapital: Boolean = false,
    val hasNumber: Boolean = false,
    val noSpaces: Boolean = false
)
