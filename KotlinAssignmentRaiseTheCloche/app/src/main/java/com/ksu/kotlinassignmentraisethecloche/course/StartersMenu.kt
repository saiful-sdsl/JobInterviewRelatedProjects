package com.ksu.kotlinassignmentraisethecloche.course

enum class StartersMenu(override val itemName: String, override val price: Int): MenuItem {
    SOUP_VEGETARIAN("Soup Vegetarian", 50),
    QUICK_BITES_VEGETARIAN("Quick Bites Vegetarian", 100) ,
    SOUP_NON_VEGETARIAN("Soup Non-Vegetarian", 65) ,
    QUICK_BITES_NON_VEGETARIAN("Quick Bites Non-Vegetarian", 110)
}


