package leetCode._3700

object Solution_3622 {
  def checkDivisibility(n: Int): Boolean =
    n % (n.toString.map(_ - '0').sum + n.toString.map(_ - '0').product) == 0
}
