package leetCode._2500

object Solution_2481 {
  def numberOfCuts(n: Int): Int =
    if (n == 1) 0
    else if (n % 2 == 0) n / 2
    else n
}
