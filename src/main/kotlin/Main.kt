/*
*
*
*
*
*
*/

class User(val id: Long, val name: String, val age: Int, val address: String)

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }
    
    validate(name, "Name")
    validate(address, "Address")
}

fun saveUser(user: User) {
    user.validateBeforeSave()
    // Save user to the database
}

fun main() {
    val user = User(1, "John", 25, "Main St.")
    saveUser(user)
}