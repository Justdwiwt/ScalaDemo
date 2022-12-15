package leetCode

object Solution_1329 {
  def diagonalSort(mat: Array[Array[Int]]): Array[Array[Int]] = {
    val (m, n) = (mat.length, mat.head.length)
    val grouped = Array.tabulate(m, n)((i, j) => (i, j) -> mat(i)(j)).flatten.groupBy(x => x._1._1 - x._1._2).values
    val diags = grouped.flatMap(_.map(_._1).map(x => x._1 * n + x._2))
    val sorted = grouped.flatMap(_.map(_._2).sorted)
    Array.tabulate(m * n)(diags.zip(sorted).toMap).sliding(n, n).toArray
  }
}
