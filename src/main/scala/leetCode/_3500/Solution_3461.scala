package leetCode._3500

object Solution_3461 {
  def hasSameDigits(s: String): Boolean = {
    @scala.annotation.tailrec
    def f(cur: String): Boolean =
      if (cur.length <= 2) cur.distinct.length == 1
      else {
        val next = cur.sliding(2).map(pair => {
          val a = pair(0).asDigit
          val b = pair(1).asDigit
          ((a + b) % 10).toString
        }).mkString
        f(next)
      }

    f(s)
  }
}
