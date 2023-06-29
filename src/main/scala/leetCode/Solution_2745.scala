package leetCode

object Solution_2745 {
  def longestString(x: Int, y: Int, z: Int): Int =
    2 * (x.min(y) * 2 + (if (x == y) 0 else 1) + z)
}
