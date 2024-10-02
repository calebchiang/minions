package com.bcit.lab4calebchiang

/**
 * Caleb Chiang
 * A01344692
 */


fun main() {
    val elf = Elf()
    val orc = Orc(elf)
    val elfCompanion = Elf()
    val huntMission = Hunt(orc, companion = elfCompanion)

    huntMission.repeat(5, object: MissionListener {
        override fun missionStart(minion: Minion) {
            println("""
                ${minion.catchphrase}

                A ${minion.race} has started a new hunt!
            """.trimIndent())
        }

        override fun missionProgress() {
            println("""
                ...
                ...
                ...
            """.trimIndent())
        }

        override fun missionComplete(minion: Minion, result: String) {
            println("A ${minion.race} has returned from a hunt, and found a $result")
        }
    })
}