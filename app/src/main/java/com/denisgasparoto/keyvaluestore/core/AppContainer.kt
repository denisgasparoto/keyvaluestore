package com.denisgasparoto.keyvaluestore.core

import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepository
import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepositoryImpl
import com.denisgasparoto.keyvaluestore.features.domain.CountValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.DeleteValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.GetValueUseCase
import com.denisgasparoto.keyvaluestore.features.domain.HandleTransactionUseCase
import com.denisgasparoto.keyvaluestore.features.domain.SetValueUseCase

class AppContainer {
    private val keyValueRepository: KeyValueRepository = KeyValueRepositoryImpl()
    val countValueUseCase = CountValueUseCase(keyValueRepository)
    val deleteValueUseCase = DeleteValueUseCase(keyValueRepository)
    val getValueUseCase = GetValueUseCase(keyValueRepository)
    val setValueUseCase = SetValueUseCase(keyValueRepository)
    val handleTransactionUseCase = HandleTransactionUseCase(keyValueRepository)

//    val useCase: UseCase = UseCase(keyValueRepository)
}
