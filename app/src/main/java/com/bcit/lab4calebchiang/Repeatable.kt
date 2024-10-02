package com.bcit.lab4calebchiang

interface Repeatable {
    abstract val repeatNum: Int
    fun repeat(int: Int, listener: MissionListener): Unit
}