package com.denisgasparoto.keyvaluestore.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denisgasparoto.keyvaluestore.features.domain.CountValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.DeleteValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.GetValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.HandleTransactionUseCase
import com.denisgasparoto.keyvaluestore.features.domain.SetValueUseCase

internal class MainViewModel(
    private val countValueUseCase: CountValueUseCase,
    private val deleteValueUseCase: DeleteValueUseCase,
    private val getValueUseCase: GetValueUseCase,
    private val handleTransactionUseCase: HandleTransactionUseCase,
    private val setValueUseCase: SetValueUseCase
) : ViewModel() {

    private val stateMutableLiveData = MutableLiveData<MainActivityViewState>()
    val stateLiveData: LiveData<MainActivityViewState> = stateMutableLiveData

//    Next steps:
//    3. Add error handling with feedback messages

    fun onCountValue(value: String) {
        countValueUseCase.invoke(value)
    }

    fun onDeleteValue(key: String) {
        deleteValueUseCase.invoke(key)
    }

    fun onGetValue(key: String) {
        val result = getValueUseCase.invoke(key)
        stateMutableLiveData.postValue(MainActivityViewState.Feedback(result.toString()))
    }

    fun onSetValue(value: String) {
        val splitValue = value.split(" ")
        setValueUseCase.invoke(splitValue[0], splitValue[1])
        stateMutableLiveData.postValue(MainActivityViewState.Feedback(value))
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
