//package com.road.rating.domain.validation
//
//import com.road.rating.domain.model.RateLicenseModel
//import com.road.rating.domain.validation.exceptions.RatingException
//import org.springframework.stereotype.Component
//
//@Component
//class RatingValidation : RateLicenseValidator {
//
//    override fun validate(rateLicenseModel: RateLicenseModel) {
//        if (Rating.values().none { it.number == rateLicenseModel.rating }) throw RatingException("Not valid number for rating")
//    }
//}