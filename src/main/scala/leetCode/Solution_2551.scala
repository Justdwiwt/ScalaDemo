package leetCode

object Solution_2551 {
  def putMarbles(weights: Array[Int], k: Int): Long = {
    val t = weights.map(_.toLong).sliding(2).map(_.sum).toArray.sorted
    t.takeRight(k - 1).sum - t.take(k - 1).sum
  }
}
