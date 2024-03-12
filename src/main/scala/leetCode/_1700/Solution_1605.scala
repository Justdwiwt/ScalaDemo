package leetCode._1700

object Solution_1605 {
  def restoreMatrix(rowSum: Array[Int], colSum: Array[Int]): Array[Array[Int]] = {
    val res = Array.ofDim[Int](rowSum.length, colSum.length)
    rowSum.indices.foreach(i => colSum.indices.foreach(j => {
      var mn = colSum(j).min(rowSum(i))
      colSum(j) -= mn
      rowSum(i) -= mn
      res(i)(j) = mn
    }))
    res
  }
}
