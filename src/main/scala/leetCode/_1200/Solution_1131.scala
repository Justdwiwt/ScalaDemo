package leetCode._1200

object Solution_1131 {
  def maxAbsValExpr(A: Array[Int], B: Array[Int]): Int = {
    var res = Int.MinValue
    A.indices.foreach(i => (i + 1 until A.length).foreach(j => {
      val t = j - i + (A(i) - A(j)).abs + (B(i) - B(j)).abs
      res = res.max(t)
    }))
    res
  }
}
