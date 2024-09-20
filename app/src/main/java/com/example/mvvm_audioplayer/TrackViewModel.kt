package com.example.mvvm_audioplayer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class TrackViewModel(private val trackId: String, tracksInteractor: TracksInteractor) :
    ViewModel() {
    init {
        Log.d("TEST", "init: $trackId")
        tracksInteractor.loadSomeData(
            onComplete = {
                // 2
                loadingLiveData.postValue(false)
                // или
                // 3
//                loadingLiveData.value = false
            }
        )
    }

    private val loadingLiveData = MutableLiveData(true)

    fun getLoadingLiveData(): LiveData<Boolean> = loadingLiveData


    companion object {
        fun getViewModelFactory(trackId: String): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    val interactor =
                        (this[APPLICATION_KEY] as MyApplication).provideTracksInteractor()

                    TrackViewModel(
                        trackId,
                        interactor,
                    )
                }
            }
    }
}