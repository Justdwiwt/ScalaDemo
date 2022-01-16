package leetCode

object Solution_2136 {
  def earliestFullBloom(plantTime: Array[Int], growTime: Array[Int]): Int = growTime
    .zip(plantTime)
    .sorted
    ./:(0) { case (res, (g, p)) => res.max(g) + p }
}
