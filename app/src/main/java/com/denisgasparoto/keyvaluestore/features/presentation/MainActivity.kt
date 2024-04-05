package com.denisgasparoto.keyvaluestore.features.presentation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.denisgasparoto.keyvaluestore.R
import com.denisgasparoto.keyvaluestore.core.MyApplication
import com.denisgasparoto.keyvaluestore.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    Next steps:
//    1. Add ViewAction and ViewState
//    3. Add error handling with feedback messages

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupStateObservers()
        setupListeners()
    }

    private fun setupViewModel() {
        val appContainer = MyApplication().appContainer
        viewModel = MainViewModel(
            appContainer.countValueUseCase,
            appContainer.deleteValueUseCase,
            appContainer.getValueUseCase,
            appContainer.handleTransactionUseCase,
            appContainer.setValueUseCase
        )
    }

    private fun setupListeners() {
        with(binding) {
            countValue.setOnClickListener {
                viewModel.onCountValue(editText.text.toString())
            }

            deleteValue.setOnClickListener {
                viewModel.onDeleteValue(editText.text.toString())
            }

            getValue.setOnClickListener {
                viewModel.onGetValue(editText.text.toString())
            }

            setValue.setOnClickListener {
                viewModel.onSetValue(editText.text.toString())
            }

            beginTransaction.setOnClickListener {
                viewModel.onBeginTransaction()
            }

            commitTransaction.setOnClickListener {
                viewModel.onCommitTransaction()
            }

            rollbackTransaction.setOnClickListener {
                viewModel.onRollbackTransaction()
            }
        }
    }

    private fun setupStateObservers() {
        viewModel.stateLiveData.observe(this) {
            when (it) {
                is MainActivityViewState.Feedback -> updateView(it.value)
                else -> throw IllegalStateException("Unresolved view state!")
            }
        }
    }

    private fun updateView(value: String) {
        with(binding) {
            textView.text = value
            Handler(Looper.getMainLooper()).postDelayed({
                textView.text = ""
            }, 1000)
        }
    }
}
