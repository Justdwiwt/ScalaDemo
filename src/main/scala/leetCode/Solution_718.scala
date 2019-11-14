package leetCode

object Solution_718 {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    var res = 0
    val dp = Array.ofDim[Int](A.length + 1, B.length + 1)
    (1 to A.length).foreach(i => (1 to B.length).foreach(j => {
      dp(i)(j) = if (A(i - 1) == B(j - 1)) dp(i - 1)(j - 1) + 1 else 0
      res = res.max(dp(i)(j))
    }))
    res
  }
}
