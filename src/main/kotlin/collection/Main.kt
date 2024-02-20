package collection

/**
 *packageName    : collection
 * fileName       : Main
 * author         : ipeac
 * date           : 2024-02-08
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-08        ipeac       최초 생성
 */
fun main() {
    val user = TwitterUser("ipeac")
    user.getNickname()
    println(user.isSubscribed)
}


open class User(val nickname: String, val isSubscribed: Boolean = true)

class TwitterUser(nickname: String) : User(nickname) {
    fun getNickname() {
        println(nickname)
    }
}