package leetCode

object Solution_365 {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = z == 0 || (x + y >= z && z % gcd(x, y) == 0)

  @scala.annotation.tailrec
  def gcd(x: Int, y: Int): Int = if (y == 0) x else gcd(y, x & y)
}
