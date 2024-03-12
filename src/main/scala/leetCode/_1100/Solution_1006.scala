package leetCode._1100

object Solution_1006 {
  def clumsy(N: Int): Int = {
    val diff = Array(1, 2, 2, -1)
    if (N > 4) N + diff(N % 4)
    else if (N > 2) N + 3
    else N
  }
}
