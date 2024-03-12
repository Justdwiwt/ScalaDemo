package leetCode._400

object Solution_390 {
  def lastRemaining(n: Int): Int = n match {
    case 1 => 1
    case _ => 2 * (1 + n / 2 - lastRemaining(n / 2))
  }
}
