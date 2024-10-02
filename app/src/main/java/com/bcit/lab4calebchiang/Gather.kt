package com.bcit.lab4calebchiang

import kotlin.random.Random

class Gather(minion: Minion, item: Item, companion: Companion) : Mission(minion, item, companion), Repeatable {
    override fun determineMissionTime(): Int {
        val randomNumber = Random.nextInt(0, 5)
        return (minion.backpackSize + minion.baseSpeed + (item.timeModifier)) * randomNumber
    }

    override fun reward(time: Int): String {
        return when (time) {
            in 10..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..44 -> "gold"
            in 45..60 -> "diamond"
            else -> "nothing"
        }
    }

    override fun repeat(int: Int, listener: MissionListener) {
        repeat(int) {
            start(listener)
        }
    }
}