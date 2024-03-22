package com.denisgasparoto.keyvaluestore.core.di

interface Factory<T> {
    fun create(): T
}
