package lb.edu.ul.befake.signup.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import lb.edu.ul.befake.utility.showToast

class SignUpFragmentViewModel: ViewModel(){
    fun emptyInput(context: Context, firstName: String, lastName: String, email: String, password: String): Boolean {
        if (firstName.isEmpty()) {
            showToast(context, "Empty Field")
            return false
        }
        if (lastName.isEmpty()) {
            showToast(context, "Empty Field")
            return false
        }
        if (email.isEmpty()) {
            showToast(context, "Empty Field")
            return false
        }
        if (password.isEmpty()) {
            showToast(context, "Empty Field")
            return false
        }
        return true
    }

    fun validInput(
        context: Context,
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Boolean {
        if (firstName.length < 2 || !firstName.matches(Regex("^[a-zA-Z]+$"))) {
            showToast(context, "Invalid first name")
            return false
        }

        if (lastName.length < 2 || !lastName.matches(Regex("^[a-zA-Z]+$"))) {
            showToast(context, "Invalid last name")
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast(context, "Invalid email format")
            return false
        }

        if (password.length < 8 ||
            !password.any { it.isDigit() } ||
            !password.any { it.isUpperCase() } ||
            !password.any { it.isLowerCase() } ||
            !password.any { "!@#\$%^&*()?_+-=[]{}|;':\",.<>/?".contains(it) }
        ) {
            showToast(
                context,
                "Password must be at least 8 characters and include uppercase, lowercase, number, and special character"
            )
            return false
        }

        return true
    }

}