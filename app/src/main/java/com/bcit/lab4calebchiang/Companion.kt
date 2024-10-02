package com.bcit.lab4calebchiang

interface Companion {

    fun huntReward(time: Int): String {
        return when (time) {
            in 11..20 -> "fish"
            in 21..30 -> "forest bear"
            in 31..40 -> "orc"
            in 41..60 -> "troll"
            else -> "nothing"
        }
    }

}