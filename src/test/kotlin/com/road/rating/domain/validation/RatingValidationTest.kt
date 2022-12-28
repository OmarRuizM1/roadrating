//package com.road.rating.domain.validation
//
//import com.road.rating.domain.model.RateLicenseModel
//import com.road.rating.domain.validation.exceptions.RatingException
//import io.mockk.impl.annotations.InjectMockKs
//import io.mockk.junit5.MockKExtension
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.assertThrows
//import org.junit.jupiter.api.extension.ExtendWith
//
//@ExtendWith(MockKExtension::class)
//internal class RatingValidationTest {
//
//    @InjectMockKs
//    private lateinit var ratingValidation: RatingValidation
//
//    @Test
//    fun validate() {
//        //Given
//        val rate = RateLicenseModel("Invalid Rate Number", "Fast Driver", 0)
//
//        //When //Then
//        assertThrows<RatingException> { ratingValidation.validate(rate) }
//    }
//}