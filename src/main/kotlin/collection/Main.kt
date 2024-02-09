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
    // Shape 타입의 리스트를 생성하고, Circle과 Rectangle 객체를 추가합니다.
    val shapes: List<Shape> = listOf(Circle(2.5), Rectangle(4.0, 5.0))

    // 모든 도형을 그리고 면적을 계산합니다.
    for (shape in shapes) {
        shape.draw()
        println("면적: ${shape.area()}")
    }
}

// 추상 클래스 선언
abstract class Shape {
    // 추상 메서드 선언
    abstract fun draw()
    abstract fun area(): Double
}

// 추상 클래스를 상속받는 구체적인 클래스
class Circle(private val radius: Double) : Shape() {
    // 추상 메서드 구현
    override fun draw() {
        println("원을 그립니다. 반지름: $radius")
    }

    // 추상 메서드 구현
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

// 추상 클래스를 상속받는 또 다른 구체적인 클래스
class Rectangle(private val width: Double, private val height: Double) : Shape() {
    // 추상 메서드 구현
    override fun draw() {
        println("사각형을 그립니다. 가로: $width, 세로: $height")
    }

    // 추상 메서드 구현
    override fun area(): Double {
        return width * height
    }
}