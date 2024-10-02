package com.bcit.lab4calebchiang
import kotlin.random.Random

class Hunt(minion: Minion, item: Item, companion: Companion) : Mission(minion, item, companion), Repeatable {
    override fun determineMissionTime(): Int {
        val randomNumber = Random.nextInt(0, 5)
        return (minion.baseHealth + minion.baseSpeed + (item.timeModifier)) * randomNumber
    }

    override fun reward(time: Int): String {
        return when (time) {
            in 11..20 -> "mouse"
            in 21..30 -> "fox"
            in 31..40 -> "buffalo"
            in 41..60 -> "dinosaur"
            else -> "nothing"
        }
    }

    override fun repeat(int: Int, listener: MissionListener) {
        repeat(int) {
            start(listener)
        }
    }

}