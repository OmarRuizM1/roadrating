package com.road.rating.domain.validation

import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.validation.NewLicenseValidation.Companion.INVALID_LICENSE
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class NewLicenseValidationTest {

    @InjectMockKs
    private lateinit var newLicenseValidation: NewLicenseValidation

    @Test
    fun `invalidating license throws an exception`() {
        //Given
        val rate = RateLicenseModel("1", "InvalidLicense", setOf("Fast Driver"), Assessment.NEGATIVE)

        //When //Then
        val exception = assertThrows<Exception> { newLicenseValidation.validate(rate) }

        Assertions.assertTrue(exception is ValidationException)
        Assertions.assertEquals(exception.message, INVALID_LICENSE)
    }
}