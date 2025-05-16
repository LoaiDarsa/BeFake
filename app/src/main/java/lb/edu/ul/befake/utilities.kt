package lb.edu.ul.befake

import android.content.Context
import android.widget.Toast

// A simple function to show a toast message
fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
