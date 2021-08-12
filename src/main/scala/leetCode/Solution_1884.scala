package leetCode

object Solution_1884 {
  def twoEggDrop(n: Int): Int =
    (math.sqrt(n * 2 - 0.25) - 0.5).ceil.toInt
}
