package sealed

/**
 *packageName    : sealed
 * fileName       : Main
 * author         : ipeac
 * date           : 2024-02-14
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-14        ipeac       최초 생성
 */

// sealed 클래스로 식 표현
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int = when (e) {
    is Expr.Num -> e.value
    is Expr.Sum -> eval(e.right) + eval(e.left)
    // 'else' 분기가 필요 없음
}