package leetCode._1800

object Solution_1744 {
  def canEat(candiesCount: Array[Int], queries: Array[Array[Int]]): Array[Boolean] = {
    val sum = candiesCount.scanLeft(0L)(_ + _)
    queries.map { case Array(x, y, z) => sum(x + 1) > y && sum(x) < (y + 1).toLong * z }
  }
}
