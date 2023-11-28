import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Reader

/*
*
*
*
*
*
*/

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    when (e) {
        is Num -> {
            e.value
        }
        
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) =
    when (c) {
        in '0'..'9' -> "It's a digit!"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
        else -> "I don't know..."
    }

fun readNumber(reader: BufferedReader): Int?{
    return try {
        val line = reader.readLine()
        println("line = $line");
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null // 예외가 발생하는 경우 null 을 반환한다.
    } finally {
        reader.close()
    }
}

fun main() {
    readNumber(BufferedReader(InputStreamReader(System.`in`)))
}