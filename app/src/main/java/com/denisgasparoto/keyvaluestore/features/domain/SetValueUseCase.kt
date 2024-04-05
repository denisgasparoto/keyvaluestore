package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepository

internal class SetValueUseCase(
    private val keyValueRepository: KeyValueRepository
) {
    operator fun invoke(key: String, value: String) = keyValueRepository.set(key, value)
}
