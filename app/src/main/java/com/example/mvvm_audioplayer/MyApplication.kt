package com.example.mvvm_audioplayer

import android.app.Application

class MyApplication: Application() {
    fun getRepository(): TracksRepository {
        return TracksRepositoryImpl(NetworkClientImpl())
    }

    fun provideTracksInteractor(): TrackInteractor {
        return TracksInteractorImpl(getRepository())
    }
}