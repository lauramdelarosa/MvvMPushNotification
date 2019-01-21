package com.delarosa.pushnotificationmvvm.model

import java.text.SimpleDateFormat
import java.util.*

class TimeRepositoryImpl : TimeRepository {
    override fun generateDate() = TimeDto(SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date()), Random(1).nextInt())

}