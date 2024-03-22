package com.denisgasparoto.keyvaluestore.features.domain

import com.denisgasparoto.keyvaluestore.features.data.Repository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations

class UseCaseTest {

//    Next steps:
//    1. Add more unit tests to get functions fully covered
//    2. Change the file name to make it clearer and more concise

    @Mock
    lateinit var mockRepository: Repository

    private lateinit var useCase: UseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        useCase = UseCase(mockRepository)
    }

    @Test
    fun `executeCommand should call repository set method for SET command`() {
        // Given
        val command = "SET key value"

        // When
        useCase.executeCommand(command)

        // Then
        verify(mockRepository).set("key", "value")
        verifyNoMoreInteractions(mockRepository)
    }

    @Test
    fun `executeCommand should call repository get method for GET command`() {
        // Given
        val command = "GET key"

        // When
        useCase.executeCommand(command)

        // Then
        verify(mockRepository).get("key")
        verifyNoMoreInteractions(mockRepository)
    }

    @Test
    fun `executeCommand should call repository delete method for DELETE command`() {
        // Given
        val command = "DELETE key"

        // When
        useCase.executeCommand(command)

        // Then
        verify(mockRepository).delete("key")
        verifyNoMoreInteractions(mockRepository)
    }

    @Test
    fun `executeCommand should call repository count method for COUNT command`() {
        // Given
        val command = "COUNT value"

        // When
        useCase.executeCommand(command)

        // Then
        verify(mockRepository).count("value")
        verifyNoMoreInteractions(mockRepository)
    }
}
