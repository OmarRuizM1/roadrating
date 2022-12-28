package com.road.rating.domain.enums

enum class Assessment {
    POSITIVE, NEGATIVE, NEUTRAL;

    companion object {
        fun returnValue(name: String?): Assessment {
            if (name == null) return NEUTRAL
            return if (enumContains(name)) Assessment.valueOf(name) else NEUTRAL
        }

        private fun enumContains(name: String): Boolean {
            return enumValues<Assessment>().any { it.name == name }
        }
    }
}





