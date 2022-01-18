package com.youview.youviewtest1

import org.junit.Test

import org.junit.Assert.*

/**
 * Define all edge cases to validate password checks security correctly
 */
class UtilsTest {
    @Test
    fun validatePasswordCantBeEmptyStringTest() {
        assertFalse(Utils.validatePassword(""))
    }
}