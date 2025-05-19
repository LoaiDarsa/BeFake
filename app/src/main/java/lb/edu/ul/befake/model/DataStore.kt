package lb.edu.ul.befake.model

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

object DataStore {
    const val PREF_DATASTORE_NAME = "BEFAKE_STORE"
    const val PREF_REMEMBER_ME = "rememberme"
    const val PREF_EMAIL = "email"

    //PREF_DATASTORE_NAME: The name of the preferences data store file.
    //PREF_REMEMBER_ME: Key name for storing the "remember me" boolean flag.
    //PREF_EMAIL: Key name for storing the user's email string.

    val Context.datastore by preferencesDataStore(name = PREF_DATASTORE_NAME)
    //Defines an extension property on Context called datastore that lazily initializes a PreferencesDataStore instance named "BEFAKE_STORE".
    //This is the DataStore object that handles reading/writing preferences asynchronously.

    suspend fun setRememberMe(context: Context, value: Boolean, key: Preferences.Key<Boolean>) {
        context.datastore.edit { preferences ->
            preferences[key] = value
        }
    }
    //A suspend function (must be called from a coroutine) that writes a Boolean value (value) into the DataStore under the provided key.
    //Uses context.datastore.edit to update the preferences transactionally.

    suspend fun setEmail(context: Context, value: String, key: Preferences.Key<String>) {
        context.datastore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun isRememberMe(context: Context, key: Preferences.Key<Boolean>): Boolean{
        val preferences = context.datastore.data.first()
        return preferences[key] ?: false
    }
    //That means:
    //You're saying: "Give me only the first value emitted (i.e., the current preferences at this moment)."
    //The first() function is a suspend function that waits (or suspends) until the first data is ready.
    // Why it's designed this way:
    //Because preferences might be updated over time, you could collect continuously with .collect { ... }, or just get the current value once using .first().
    //Analogy:
    //Think of a Flow like a radio station continuously broadcasting updates.
    //Using .first() is like turning on the radio, listening to the first announcement, and turning it off.

    suspend fun getEmail(context: Context, key: Preferences.Key<String>): String {
        val preferences = context.datastore.data.first()
        return preferences[key] ?: ""
    }
}