package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.KeyValueRepository

class DeleteValueUseCase(
    private val keyValueRepository: KeyValueRepository
) {
    operator fun invoke(key: String) = keyValueRepository.delete(key)
}
