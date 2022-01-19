package com.youview.youviewtest1

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object Utils {

    /**
     * Please define rules which makes password secure.
     * Implement password validation function which checks security rules.
     * Example below define password can't be shorter than 10 characters.
     */

    private val PASSWORD_POLICY = """Password should be minimum 10 characters long,
        |should contain at least one capital letter,
        |at least one small letter,
        |at least one number and
        |at least one special character among ~!@#$%^&*()-_=+|[]{};:',<.>/?""".trimMargin()

       private fun getText(data: Any): String {
           var str = ""
           if (data is EditText) {
               str = data.text.toString()
           } else if (data is String) {
               str = data
           }
           return str
       }


    fun validatePassword(passwd: String, updateUI : Boolean = true) : Boolean {
        val str = getText(passwd)
        var valid = true

        if (str.length < 10) {
            valid = false
        }

        var exp = ".*[0-9].*"
        var pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE)
        var matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            valid = false
        }

        exp = ".*[A-Z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            valid = false
        }

        exp = ".*[a-z].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            valid = false
        }

        exp = ".*[~!@#\$%\\^&*()\\-_=+\\|\\[{\\]};:'\",<.>/?].*"
        pattern = Pattern.compile(exp)
        matcher = pattern.matcher(str)
        if (!matcher.matches()) {
            valid = false
        }

        if (updateUI) {


            val error: String? = if (valid) null else PASSWORD_POLICY
            setError(passwd, error)

        }
        return passwd.length >= 10
    }




        private fun setError(passwd: Any, error: String?) {
            if (passwd is EditText) {
            if(passwd.parent.parent is TextInputLayout) {
                (passwd.parent.parent as TextInputLayout).error = error
            }

            }
        }
    }

