package com.bcit.lab4calebchiang

import kotlin.properties.Delegates
import kotlin.random.Random

class Gather(minion: Minion, item: Item? = null, companion: Companion? = null) : Mission(minion, item, companion), Repeatable {

    override var repeatNum: Int by Delegates.vetoable(0) { _, _, newValue ->
        newValue <= 3
    }

    override fun determineMissionTime(): Int {
        val randomNumber = Random.nextInt(0, 5)
        return (minion.backpackSize + minion.baseSpeed + (item?.timeModifier ?: 0)) * randomNumber
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
        if (int > 3) {
            println("A ${minion.race} cannot repeat a gather more than 3 times. Repeating a gather 3 times...")
            repeatNum = 3
        } else {
            repeatNum = int
            println("Repeating a gather $int times...\n")
        }

        repeat(repeatNum) {
            start(listener)
        }
    }
}