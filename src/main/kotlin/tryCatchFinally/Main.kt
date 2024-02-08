package tryCatchFinally

import java.io.BufferedReader

/**
 *packageName    : tryCatchFinally
 * fileName       : Main
 * author         : ipeac
 * date           : 2024-02-07
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-07        ipeac       최초 생성
 */

fun main() {
    //시스템에서 입력받기
    val reader = BufferedReader(System.`in`.reader())
    readNumber(reader)
}

private fun readNumber(reader: BufferedReader) {
    val number = try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null
    }
    println("number: $number")
}