package com.bcit.lab4calebchiang

abstract class Mission(
    protected val minion: Minion,
    protected val item: Item? = null,
    protected val companion: Companion? = null,
){

    protected abstract fun determineMissionTime(): Int
    protected abstract fun reward(time: Int): String

    fun start(listener: MissionListener): Unit {
        listener.missionStart(minion)
        val missionTime = determineMissionTime()
        listener.missionProgress()

        Thread.sleep(missionTime.toLong())  // Convert missionTime to Long and sleep
        val result = reward(missionTime)
        listener.missionComplete(minion, result)
    }
}