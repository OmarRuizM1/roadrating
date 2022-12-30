package com.road.rating.domain.validation

import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import com.road.rating.domain.validation.licenses.NewLicenseValidator
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class NewLicenseValidatorTest {

    @InjectMockKs
    private lateinit var newLicenseValidator: NewLicenseValidator

    @Test
    fun `invalid license throws an exception`() {
        //Given
        val rate = RateLicenseModel("1", "InvalidLicense", setOf("Fast Driver"), Assessment.NEGATIVE)

        //When
        val result = newLicenseValidator.isCorrectLicense(rate)

        //Then
        Assertions.assertFalse(result)
    }

    @Test
    fun `valid license`() {
        //Given
        val rate = RateLicenseModel("1", "4567DKF", setOf("Fast Driver"), Assessment.NEGATIVE)

        //When
        val result = newLicenseValidator.isCorrectLicense(rate)

        //Then
        Assertions.assertTrue(result)
    }
}