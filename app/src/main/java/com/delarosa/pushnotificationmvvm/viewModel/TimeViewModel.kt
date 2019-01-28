package com.delarosa.pushnotificationmvvm.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.delarosa.pushnotificationmvvm.model.TimeDto
import com.delarosa.pushnotificationmvvm.model.TimeRepository

class TimeViewModel(val timeRepository: TimeRepository) : ViewModel() {

    var actualTime = MutableLiveData<String>()

    init {
        actualTime.value = "La hora actual es: "

    }

    fun getCurrentTime() {
        val newTime = actualTime.value + getDescription(timeRepository.generateDate())
        actualTime.postValue(newTime)
    }

    private fun getDescription(date: TimeDto): String {
        return date.id.toString() + " " + date.time
    }

    val showNotificationPanelCompletion = MutableLiveData<Void?>()

    fun showNotificationPanel() {
        showNotificationPanelCompletion.postValue(null)
    }

}