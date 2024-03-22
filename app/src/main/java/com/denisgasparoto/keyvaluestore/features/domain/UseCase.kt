package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.Repository

class UseCase(private val repository: Repository) {

//    Next steps:
//    1. Segregate one UseCase per command
//    2. Change the file name to make it clearer and more concise
//    3. Add constants to commands name

    private val transactionStack = mutableListOf<MutableMap<String, String>>()

    fun executeCommand(command: String) {
        val parts = command.split(" ")
        when (parts[0].uppercase()) {
            "SET" -> repository.set(parts[1], parts[2])
            "GET" -> repository.get(parts[1])
            "DELETE" -> repository.delete(parts[1])
            "COUNT" -> repository.count(parts[1])
            "BEGIN" -> beginTransaction()
            "COMMIT" -> commitTransaction()
            "ROLLBACK" -> rollbackTransaction()
        }
    }

    private fun beginTransaction() {
        transactionStack.add(repository.getAll().toMutableMap())
    }

    private fun commitTransaction() {
        transactionStack.clear()
    }

    private fun rollbackTransaction() {
        if (transactionStack.isNotEmpty()) {
            repository.replaceAll(transactionStack.removeAt(transactionStack.size - 1))
        }
    }
}
