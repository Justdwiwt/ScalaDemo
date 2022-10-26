package leetCode

object Solution_2437 {
  def countTime(time: String): Int = {
    val hours =
      (time.head, time(1)) match {
        case ('?', '?') => 24
        case (c, '?') => if (c == '2') 4 else 10
        case ('?', c) => if (c - '0' <= 3) 3 else 2
        case _ => 1
      }

    val m1 = if (time(3) == '?') 6 else 1
    val m2 = if (time(4) == '?') 10 else 1

    hours * m1 * m2
  }
}
