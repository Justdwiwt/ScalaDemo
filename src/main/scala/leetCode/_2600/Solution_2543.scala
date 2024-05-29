package leetCode._2600

object Solution_2543 {
  def isReachable(targetX: Int, targetY: Int): Boolean = {
    val g = gcd(targetX, targetY)
    (g & (g - 1)) == 0
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a.abs else gcd(b, a % b)
}
