package leetCode._2300

object Solution_2274 {
  def maxConsecutive(bottom: Int, top: Int, special: Array[Int]): Int =
    ((bottom - 1) +: special.sorted :+ (top + 1))
      .sliding(2)
      .map { case Array(i, j) => j - i - 1 }
      .max
}
