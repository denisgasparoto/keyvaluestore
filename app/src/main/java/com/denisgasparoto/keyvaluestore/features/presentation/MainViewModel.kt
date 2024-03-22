package com.denisgasparoto.keyvaluestore.features.presentation

import androidx.lifecycle.ViewModel
import com.denisgasparoto.keyvaluestore.features.domain.UseCase


class MainViewModel(private val useCase: UseCase) : ViewModel() {

//    Next steps:
//    1. Add ViewAction and ViewState observers
//    2. Add user interaction handling functions
//    3. Add error handling with feedback messages
//    4. Segregate one UseCase per command
//    5. Change the file name to make it clearer and more concise

    fun executeCommand(command: String) {
        useCase.executeCommand(command)
    }
}
