package leetCode

object Solution_931 {
  def minFallingPathSum(A: Array[Array[Int]]): Int = {
    (0 to A.length - 2).reverse.foreach(r => A.indices.foreach(c => {
      var t = A(r + 1)(c)
      if (c > 0) t = t.min(A(r + 1)(c - 1))
      if (c + 1 < A.length) t = t.min(A(r + 1)(c + 1))
      A(r)(c) += t
    }))
    Int.MaxValue.min(A(0).min)
  }
}
