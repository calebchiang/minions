package com.bcit.lab4calebchiang

class Orc(private val delegate: Minion) : Minion, Companion {
    override val race = "Orc"
    override val catchphrase = "ARRGH!"
    override val baseHealth = delegate.baseHealth
    override val baseSpeed = delegate.baseSpeed
    override val backpackSize = delegate.backpackSize
}