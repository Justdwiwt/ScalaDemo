package leetCode._1100

object Solution_1035 {
  def maxUncrossedLines(A: Array[Int], B: Array[Int]): Int = {
    val arr = Array.ofDim[Int](A.length + 1, B.length + 1)
    (1 to A.length).foreach(i => (1 to B.length).foreach(j => arr(i)(j) = if (A(i - 1) == B(j - 1)) arr(i - 1)(j - 1) + 1 else arr(i - 1)(j).max(arr(i)(j - 1))))
    arr.last.last
  }
}
