package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepository

internal class GetValueUseCase(
    private val keyValueRepository: KeyValueRepository
) {
    operator fun invoke(key: String) = keyValueRepository.get(key)
}
