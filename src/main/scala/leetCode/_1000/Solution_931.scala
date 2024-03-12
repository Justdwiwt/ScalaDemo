package leetCode._1000

object Solution_931 {
  def minFallingPathSum(matrix: Array[Array[Int]]): Int = matrix
    .indices
    .dropRight(1)
    .reverse
    ./:(matrix.last.toSeq) { case (rowBelow, r) =>
      rowBelow.indices.map(c => matrix(r)(c) + rowBelow.slice(c - 1, c + 2).min)
    }
    .min
}
