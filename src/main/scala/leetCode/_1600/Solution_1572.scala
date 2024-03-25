package leetCode._1600

object Solution_1572 {
  def diagonalSum(mat: Array[Array[Int]]): Int = mat
    .indices.flatMap(i => mat
      .indices
      .withFilter(j => j == i || j == mat.length - i - 1)
      .map(mat(i)(_)))
    .sum
}
