package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepository

class UseCase(private val keyValueRepository: KeyValueRepository) {

//    Next steps:
//    1. Segregate one UseCase per command
//    2. Change the file name to make it clearer and more concise
//    3. Add constants to commands name

    private val transactionStack = mutableListOf<MutableMap<String, String>>()

    fun executeCommand(command: String) {
        val parts = command.split(" ")
        when (parts[0].uppercase()) {
            "SET" -> keyValueRepository.set(parts[1], parts[2])
            "GET" -> keyValueRepository.get(parts[1])
            "DELETE" -> keyValueRepository.delete(parts[1])
            "COUNT" -> keyValueRepository.count(parts[1])
            "BEGIN" -> beginTransaction()
            "COMMIT" -> commitTransaction()
            "ROLLBACK" -> rollbackTransaction()
        }
    }

    private fun beginTransaction() {
        transactionStack.add(keyValueRepository.getAll().toMutableMap())
    }

    private fun commitTransaction() {
        transactionStack.clear()
    }

    private fun rollbackTransaction() {
        if (transactionStack.isNotEmpty()) {
            keyValueRepository.replaceAll(transactionStack.removeAt(transactionStack.size - 1))
        }
    }
}
