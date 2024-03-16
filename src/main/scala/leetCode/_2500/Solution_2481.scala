package leetCode._2500

object Solution_2481 {
  def numberOfCuts(n: Int): Int =
    if (n == 1) 0
    else n >> ((~n) & 1)
}
