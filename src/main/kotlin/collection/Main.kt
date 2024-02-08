package collection

import strings.joinToString

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
    val joinToString = joinToString(listOf("Kotlin", "Java", "C++"), "; ")
    println(joinToString.lastChar);
}

val String.lastChar: Char
    get() = get(length - 1)