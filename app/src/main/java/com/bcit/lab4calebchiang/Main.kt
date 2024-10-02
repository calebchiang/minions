package com.bcit.lab4calebchiang

/**
 * Caleb Chiang
 * A01344692
 */


fun main() {
    val elf = Elf()
    val orc = Orc(elf)
    val humanItem = Item.NECKLACE
    val humanCompanion = Elf()
    val huntMission = Hunt(orc, humanItem, humanCompanion)

    huntMission.repeat(3, object: MissionListener {
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