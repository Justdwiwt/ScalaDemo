package leetCode

object Solution_2001 {
  def interchangeableRectangles(rectangles: Array[Array[Int]]): Long = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

    val f = (c: Long) => (1L + c) * c / 2L
    rectangles.groupBy[String](rec => {
      val g = gcd(rec.head, rec(1))
      rec.head / g + "@" + rec(1) / g
    }).map({ case (_, a) => f((a.length - 1).toLong) }).sum
  }
}
