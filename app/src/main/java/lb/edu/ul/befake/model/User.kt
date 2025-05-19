package lb.edu.ul.befake.model

import androidx.room.Entity
import java.io.Serializable

@Entity(tableName = "BEFAKE_USER")
class User(
    var id: Int = 0,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = ""
):Serializable