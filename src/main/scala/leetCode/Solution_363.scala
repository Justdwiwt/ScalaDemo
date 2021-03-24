package leetCode

object Solution_363 {
  def maxSumSubmatrix(matrix: Array[Array[Int]], k: Int): Int = {
    val dp = Array.ofDim[Int](matrix.length + 1, matrix.head.length + 1)
    dp(1)(1) = matrix.head.head
    matrix.head.indices.drop(1).foreach(i => dp(1)(i + 1) = dp(1)(i) + matrix.head(i))
    matrix.indices.drop(1).foreach(j => dp(j + 1)(1) = dp(j)(1) + matrix(j).head)
    matrix.indices.drop(1).foreach(i => matrix.head.indices.drop(1).foreach(j => dp(i + 1)(j + 1) = dp(i)(j + 1) + dp(i + 1)(j) - dp(i)(j) + matrix(i)(j)))
    var res = Int.MinValue
    (0 to matrix.head.length).foreach(j1 => (j1 + 1 to matrix.head.length).foreach(j2 => (0 to matrix.length).foreach(i1 => (i1 + 1 to matrix.length).foreach(i2 => {
      val t = dp(i2)(j2) + dp(i1)(j1) - dp(i1)(j2) - dp(i2)(j1)
      if (t == k) return k
      else if (t < k) res = res.max(t)
    }))))
    res
  }
}
