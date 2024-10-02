package com.bcit.lab4calebchiang
import kotlin.properties.Delegates
import kotlin.random.Random

class Hunt(minion: Minion, item: Item? = null, companion: Companion? = null) : Mission(minion, item, companion), Repeatable {

    override var repeatNum: Int by Delegates.vetoable(0) { _, _, newValue ->
        newValue <= 3
    }

    override fun determineMissionTime(): Int {
        val randomNumber = Random.nextInt(0, 5)
        return (minion.baseHealth + minion.baseSpeed + (item?.timeModifier ?: 0)) * randomNumber
    }

    override fun reward(time: Int): String {
        companion?.let { // check if a companion is present
            return it.huntReward(time)
        }

        return when (time) {
            in 11..20 -> "mouse"
            in 21..30 -> "fox"
            in 31..40 -> "buffalo"
            in 41..60 -> "dinosaur"
            else -> "nothing"
        }
    }

    override fun repeat(int: Int, listener: MissionListener) {
        if (int > 3) {
            println("A ${minion.race} cannot repeat a hunt more than 3 times. Repeating a hunt 3 times...")
            repeatNum = 3
        } else {
            repeatNum = int
            println("Repeating a hunt $int times...\n")
        }

        repeat(repeatNum) {
            start(listener)
        }
    }

}