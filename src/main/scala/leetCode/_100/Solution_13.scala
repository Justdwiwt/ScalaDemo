package leetCode._100

object Solution_13 {
  private val m = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

  def romanToInt(s: String): Int = f(s.reverse.toList)

  @scala.annotation.tailrec
  def f(l: List[Char], acc: Int = 0, curr: Char = 'I'): Int = l match {
    case Nil => acc
    case x :: xs if curr == x => f(xs, acc + m(x), curr)
    case x :: xs if m(x) < m(curr) => f(xs, acc - m(x), curr)
    case x :: xs if m(x) > m(curr) => f(xs, acc + m(x), x)
    case _ => acc
  }
}
