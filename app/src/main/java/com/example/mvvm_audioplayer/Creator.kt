package com.example.mvvm_audioplayer

object Creator {
    fun getRepository(): TracksRepository {
        return TracksRepositoryImpl(NetworkClientImpl())
    }

    fun provideTracksInteractor(): TrackInteractor {
        return TracksInteractorImpl(getRepository())
    }
}