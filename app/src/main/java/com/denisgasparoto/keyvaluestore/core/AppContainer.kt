package com.denisgasparoto.keyvaluestore.core

import com.denisgasparoto.keyvaluestore.features.data.Repository
import com.denisgasparoto.keyvaluestore.features.data.RepositoryImpl
import com.denisgasparoto.keyvaluestore.features.domain.UseCase

class AppContainer {
    private val repository: Repository = RepositoryImpl()
    val useCase: UseCase = UseCase(repository)
}
