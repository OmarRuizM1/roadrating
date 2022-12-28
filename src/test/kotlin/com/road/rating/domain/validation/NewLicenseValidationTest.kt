package com.road.rating.domain.validation

import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class NewLicenseValidationTest {

    @InjectMockKs
    private lateinit var newLicenseValidation: NewLicenseValidation

    @Test
    fun validate() {
        //Given
        val rate = RateLicenseModel("InvalidLicense", "1234ABC", setOf("Fast Driver"), Assessment.NEGATIVE)

        //When //Then
        assertThrows<ValidationException> { newLicenseValidation.validate(rate) }
    }
}