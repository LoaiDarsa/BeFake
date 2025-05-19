package lb.edu.ul.befake.signup.viewmodels

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import lb.edu.ul.befake.model.DataStore

class LogInFragmentViewModel: ViewModel(){
    private val emailLiveData = MutableLiveData<String>()
    private val rememberMeLiveData = MutableLiveData<Boolean>()

    fun liveEmail(): LiveData<String> {
        return emailLiveData
    }

    fun liveIsRememberMe(): LiveData<Boolean> {
        return rememberMeLiveData
    }

    fun saveData(context: Context, rememberMe: Boolean, email: String) {
        if (rememberMe) {
            viewModelScope.launch {
                DataStore.setRememberMe(context, rememberMe, booleanPreferencesKey(DataStore.PREF_REMEMBER_ME))
                DataStore.setEmail(context, email, stringPreferencesKey(DataStore.PREF_EMAIL))
            }
        }
    }
    //Why Use ViewModel?	Reason
    //Survives Configuration Changes	Keeps data intact when Activity/Fragment is recreated during screen rotations or config changes.
    //Separates UI from Logic	Moves business logic out of UI code for cleaner, more maintainable, and testable code.
    //Lifecycle-Aware Background Work	Automatically cancels ongoing tasks when ViewModel is destroyed, preventing crashes and leaks.
    //Improves Testability	Enables easy unit testing because it doesn’t depend directly on UI components.
    //Recommended Best Practice	Google encourages ViewModel use as part of modern Android app architecture (MVVM).

    fun getData(context: Context) {
        viewModelScope.launch {
            emailLiveData.value = DataStore.getEmail(context, stringPreferencesKey(DataStore.PREF_EMAIL))
            rememberMeLiveData.value = DataStore.isRememberMe(context, booleanPreferencesKey(DataStore.PREF_REMEMBER_ME))
        }
    }
}