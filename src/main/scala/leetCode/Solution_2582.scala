package leetCode

object Solution_2582 {
  def passThePillow(n: Int, time: Int): Int =
    (Stream(1) ++ Stream.continually((2 to n) ++ (n - 1 to 1 by -1)).flatten).take(time + 1).last
}
