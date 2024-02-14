# [KOTLIN] 봉인된 클래스(sealed class) : 클래스 계층의 확장 제한

### 기본

- sealed 클래스
    - 클래스 계층을 정의할 때 계층 확장을 제한하는 방법 제공함.
    - 하위 클래스는 모든 가능한 하위 타입을 제한적으로 나열할 수 있게 함.
        - when 식에서 else 분기 없이도 완전성을 보장한다.

### 예제 : 식(Expression) 계층

```kotlin
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.right) + eval(e.left)
    else -> throw IllegalArgumentException("Unknown expression")
}
```

- 위의 구조에서 else 는 필수적임.
- 코틀린 컴파일러는 `when` 을 사용할 떄 Expr ( 식타입의 ) 모든 가능한 하위 클래스를 처리하도록 강제한다.

### `sealed` 클래스를 사용한 개선

```kotlin
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
```

- sealed 클래스
    - 자동으로 `open`  `open` 변경자가 필요없음
    - 모든 하위 클래스는 중첩 클래스
    - `when` 식에서 `sealed` 클래스는 모든 하위 클래스를 처리하기에, 별도 else 불필요

### sealed 클래스 특징

- 클래스 외부에 자신을 상속한 클래스를 둘 수 없음.
- 상속 계층에 새로운 하위 클래스를 추가하면 `when` 식이 컴파일되지 않기에, `when` 식을 수정해야한다.
- 내부적으로 생성자는 `private` 이다.
- `sealed` 인터페이스는 없다. ( 코틀린 1.5 에서 추가됨 )

### 코틀린 버전에 따른 sealed 클래스의 변화

- 코틀린 1.0 : `sealed` 클래스는 같은 파일 내에서만 하위 클래스를 정의할 수 있음.
- 코틀린 1.5 : `sealed` 클래스의 하위 클래스를 패키지 내 어디에서나 정의할 수 있음. `sealed` 인터페이스 추가됨.

### 클래스 확장과 초기화

- 코틀린에서 클래스 확장 혹은 인터페이스 구현시 콜론(:) 을 사용함

```kotlin
class Num(val value: Int) : Expr()
```

- `Expr` 클래스를 상속받는 `Num` 클래스의 생성자 호출