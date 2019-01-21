package com.delarosa.pushnotificationmvvm.model

interface TimeRepository {
    fun generateDate(): TimeDto
}