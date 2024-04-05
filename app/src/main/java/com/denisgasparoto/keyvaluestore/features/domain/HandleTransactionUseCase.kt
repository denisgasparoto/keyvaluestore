package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepository

internal class HandleTransactionUseCase(
    private val keyValueRepository: KeyValueRepository
) {
    private val transactionStack = mutableListOf<MutableMap<String, String>>()
    fun beginTransaction() {
        transactionStack.add(keyValueRepository.getAll().toMutableMap())
    }

    fun commitTransaction() {
        transactionStack.clear()
    }

    fun rollbackTransaction() {
        if (transactionStack.isNotEmpty()) {
            keyValueRepository.replaceAll(
                transactionStack.removeAt(transactionStack.size.minus(1))
            )
        }
    }
}
