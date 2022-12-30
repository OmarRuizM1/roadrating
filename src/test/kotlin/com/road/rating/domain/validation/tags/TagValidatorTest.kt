package com.road.rating.domain.validation.tags

import com.road.rating.domain.enums.Assessment
import com.road.rating.domain.model.RateLicenseModel
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
internal class TagValidatorTest {

    @InjectMockKs
    private lateinit var tagValidator: TagValidator

    @Test
    fun `Existing tag`() {
        //Given
        val rate = RateLicenseModel("1", "InvalidLicense", setOf("Aparcó mal"), Assessment.NEGATIVE)

        //When
        val result = tagValidator.areCorrectTags(rate)

        //Then
        assertTrue(result)
    }

    @Test
    fun `Not existing tag`() {
        //Given
        val rate = RateLicenseModel("1", "InvalidLicense", setOf("pene rasurado"), Assessment.NEGATIVE)

        //When
        val result = tagValidator.areCorrectTags(rate)

        //Then
        assertFalse(result)
    }
}