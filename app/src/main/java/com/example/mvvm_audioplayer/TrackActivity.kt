package com.example.mvvm_audioplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class TrackActivity : ComponentActivity() {
    private lateinit var viewModel: TrackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(
            this,
            TrackViewModel.getViewModelFactory("123")
        )[TrackViewModel::class.java]

        viewModel.getLoadingLiveData().observe(this) { isLoading ->
            changeProgressBarVisibility(isLoading)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
//        viewModel.removeLoadingObserver()
    }

    private fun changeProgressBarVisibility(visible: Boolean) {
        // Обновляем видимость прогресс-бара
    }

}