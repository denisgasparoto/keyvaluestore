package com.denisgasparoto.keyvaluestore.features.data

interface Repository {
    fun set(key: String, value: String)
    fun get(key: String): String?
    fun delete(key: String)
    fun count(value: String)
    fun getAll(): Map<String, String>
    fun replaceAll(newData: Map<String, String>)
}
