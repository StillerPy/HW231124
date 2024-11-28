package ru.netology

class Likes {
    var amount = 0
    fun like() {
        amount++
    }
    fun unlike() {
        amount--
    }
    override fun toString(): String {
        return "$amount like(s)"
    }
}