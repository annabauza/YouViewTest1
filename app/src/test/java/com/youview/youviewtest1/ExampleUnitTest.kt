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
    @Test
    fun validatePasswordMissingOneNumberTest() {
        assertFalse(Utils.validatePassword("Abcdefg#"))
    }

    @Test
    fun validatePasswordMissingOneUpperCaseTest() {
        assertFalse(Utils.validatePassword("abcdefg5#"))
    }
    @Test
    fun validatePasswordMissingOneLowerCaseTest() {
        assertFalse(Utils.validatePassword("ABCDEFG5#"))
    }

    @Test
    fun validatePasswordAllRulesMet() {
        assertFalse(Utils.validatePassword("Abcdefg5#"))

    }
    @Test
    fun validatePasswordLengthTooLong() {
        assertTrue(Utils.validatePassword("Abcdefg5#abcdefg5678"))
    }


}
