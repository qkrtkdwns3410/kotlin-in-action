/**
 *packageName    :
 * fileName       : Strings
 * author         : ipeac
 * date           : 2023-11-28
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-28        ipeac       최초 생성
 */
package strings

fun String.lastChar(): Char = this.get(this.length - 1)

fun main() {
    val joinToString = listOf("one", "two", "eight").joinToString(separator = " ", prefix = "(", postfix = ")")
    println("joinToString = $joinToString")
    println("Kotlin".lastChar())
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}