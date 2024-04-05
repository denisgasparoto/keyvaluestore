package com.denisgasparoto.keyvaluestore.features.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denisgasparoto.keyvaluestore.R
import com.denisgasparoto.keyvaluestore.core.MyApplication
import com.denisgasparoto.keyvaluestore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

//    Next steps:
//    1. Add ViewAction and ViewState
//    2. Add user interaction handling functions
//    3. Add error handling with feedback messages

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val appContainer = MyApplication().appContainer
        val viewModel = MainViewModel(
            appContainer.countValueUseCase,
            appContainer.deleteValueUseCase,
            appContainer.getValueUseCase,
            appContainer.handleTransactionUseCase,
            appContainer.setValueUseCase
        )

        binding.executeButton.setOnClickListener {
            val command = binding.commandEditText.text.toString()
            viewModel.executeCommand(command)
        }

        binding.beginTransaction.setOnClickListener {
            viewModel.onBeginTransaction()
        }
        binding.commitTransaction.setOnClickListener {
            viewModel.onCommitTransaction()
        }
        binding.rollbackTransaction.setOnClickListener {
            viewModel.onRollbackTransaction()
        }
    }
}
