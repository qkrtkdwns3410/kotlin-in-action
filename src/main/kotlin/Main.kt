/*
*
*
*
*
*
*/

fun main(args: Array<String>) {
    for (i in 100..<200 step 2) {
        println(i)
    }
}

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