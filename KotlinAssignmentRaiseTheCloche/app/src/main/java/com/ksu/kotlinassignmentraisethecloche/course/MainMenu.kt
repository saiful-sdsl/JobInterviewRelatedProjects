package com.ksu.kotlinassignmentraisethecloche.course


enum class MainMenu(override val itemName: String, override val price: Int): MenuItem {
    CURRY_VEGETARIAN("Curry Vegetarian", 135),
    CURRY_NON_VEGETARIAN("Curry Non-Vegetarian", 150),
    NOODLES_VEGETARIAN("Noodles Vegetarian", 120),
    NOODLES_NON_VEGETARIAN("Noodles Non-Vegetarian", 130)
}

