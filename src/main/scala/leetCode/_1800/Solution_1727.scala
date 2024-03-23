package leetCode._1800

object Solution_1727 {
  def largestSubmatrix(matrix: Array[Array[Int]]): Int = matrix
    .indices
    .foldLeft(Seq.fill(matrix.head.length)(0), 0) { case ((heights, res), r) =>
      val newHeights = heights.zipWithIndex.map { case (h, c) => if (matrix(r)(c) == 0) 0 else h + 1 }
      val rowRes = newHeights.sorted.zipWithIndex.map { case (h, c) => h * (matrix.head.length - c) }
      (newHeights, rowRes.max.max(res))
    }
    ._2
}
