package com.road.rating.domain.util

import org.springframework.stereotype.Component

@Component
class PrepareLicenseUtil {

    fun prepare(string: String) = string.trim().uppercase().filterNot { it.isWhitespace() || it == '-' || it == '/' || it == '|' || it == '.' }

}