package com.denisgasparoto.keyvaluestore.features.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.denisgasparoto.keyvaluestore.R
import com.denisgasparoto.keyvaluestore.core.MyApplication


class MainActivity : AppCompatActivity() {

//    Next steps:
//    1. Add ViewAction and ViewState
//    2. Add user interaction handling functions
//    3. Add error handling with feedback messages
//    5. Change the file name to make it clearer and more concise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appContainer = MyApplication().appContainer
        val viewModel = MainViewModel(appContainer.useCase)

        val commandEditText = findViewById<EditText>(R.id.commandEditText)
        val executeButton = findViewById<Button>(R.id.executeButton)

        executeButton.setOnClickListener {
            val command = commandEditText.text.toString()
            viewModel.executeCommand(command)
        }
    }
}
