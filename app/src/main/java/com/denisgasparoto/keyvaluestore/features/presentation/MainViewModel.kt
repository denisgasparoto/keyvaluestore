package com.denisgasparoto.keyvaluestore.features.presentation

import androidx.lifecycle.ViewModel
import com.denisgasparoto.keyvaluestore.features.domain.CountValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.DeleteValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.GetValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.HandleTransactionUseCase
import com.denisgasparoto.keyvaluestore.features.domain.SetValueUseCase


class MainViewModel(
    private val countValueUseCase: CountValueUseCase,
    private val deleteValueUseCase: DeleteValueUseCase,
    private val getValueUseCase: GetValueUseCase,
    private val handleTransactionUseCase: HandleTransactionUseCase,
    private val setValueUseCase: SetValueUseCase
) : ViewModel() {

//    Next steps:
//    1. Add ViewAction and ViewState observers
//    2. Add user interaction handling functions
//    3. Add error handling with feedback messages
//    4. Segregate one UseCase per command
//    5. Change the file name to make it clearer and more concise

    fun executeCommand(command: String) {
//        useCase.executeCommand(command)
    }

    fun onBeginTransaction() {
        handleTransactionUseCase.beginTransaction()
    }

    fun onCommitTransaction() {
        handleTransactionUseCase.commitTransaction()
    }

    fun onRollbackTransaction() {
        handleTransactionUseCase.rollbackTransaction()
    }
}
