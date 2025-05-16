package lb.edu.ul.befake.signup.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import lb.edu.ul.befake.showToast

class SignUpFragmentViewModel: ViewModel(){
    fun validInput(context: Context, firstName: String, lastName: String, email: String, phoneNumber: String): Boolean {
        if (firstName.isEmpty()) {
            showToast(context, "Invalid Input")
            return false
        }
        if (lastName.isEmpty()) {
            showToast(context, "Invalid Input")
            return false
        }
        if (email.isEmpty()) {
            showToast(context, "Invalid Input")
            return false
        }
        if (phoneNumber.isEmpty()) {
            showToast(context, "Invalid Input")
            return false
        }
        return true
    }
}