package lb.edu.ul.befake.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import lb.edu.ul.befake.model.User

interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("DELETE FROM BEFAKE_USER WHERE lastName = :lastname and firstName = :firstname")
    suspend fun deleteUser(lastname: String, firstname: String)

    @Query("SELECT firstName, lastName FROM BEFAKE_USER WHERE email = :email")
    suspend fun getUser(email: String): User?

    @Query("SELECT count(*) = 0 FROM BEFAKE_USER WHERE email = :email")
    suspend fun isUniqueUser(email: String): Boolean
}