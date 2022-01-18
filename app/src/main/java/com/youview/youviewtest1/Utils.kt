package com.youview.youviewtest1

object Utils {

    /**
     * Please define rules which makes password secure.
     * Implement password validation function which checks security rules.
     * Example below define password can't be shorter than 10 characters.
     */
    fun validatePassword(passwd: String) : Boolean {
        return passwd.length >= 10
    }
}