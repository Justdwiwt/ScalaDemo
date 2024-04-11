package leetCode._3100

object Solution_3032 {
  def numberCount(a: Int, b: Int): Int =
    (a to b).count(isUnique)

  private def isUnique(n: Int): Boolean = {
    val digits = Stream.iterate(n)(_ / 10).takeWhile(_ > 0).map(_ % 10)
    digits.toSet.size == digits.length
  }
}
