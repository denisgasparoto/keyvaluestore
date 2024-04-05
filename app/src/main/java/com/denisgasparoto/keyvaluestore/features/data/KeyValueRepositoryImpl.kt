package com.denisgasparoto.keyvaluestore.features.data

import timber.log.Timber

internal class KeyValueRepositoryImpl : KeyValueRepository {

    private val keyValueMap = mutableMapOf<String, String>()

    override fun set(key: String, value: String) {
        keyValueMap[key] = value
        Timber.d("Set key: '$value': $value")
    }

    override fun get(key: String): String? {
        Timber.d("Get key: '$key'")
        return keyValueMap[key]
    }

    override fun delete(key: String) {
        keyValueMap.remove(key)
        Timber.d("Delete key: '$key'")
    }

    override fun count(value: String) {
        val count = keyValueMap.count { it.value == value }
        Timber.d("Count of keys with value '$value': $count")
    }

    override fun getAll(): Map<String, String> {
        Timber.d("Get all invoked", keyValueMap.toMap())
        return keyValueMap.toMap()
    }

    override fun replaceAll(newData: Map<String, String>) {
        Timber.d("Replace all invoked", newData)
        keyValueMap.clear()
        keyValueMap.putAll(newData)
    }
}
