package leetCode._1300

object Solution_1292 {
  def maxSideLength(mat: Array[Array[Int]], threshold: Int): Int = {
    val m = mat.length
    val n = mat.head.length
    val sum = Array.ofDim[Int](m + 1, n + 1)
    var res = 0
    var len = 1
    (1 to m).foreach(i => (1 to n).foreach(j => {
      sum(i)(j) = sum(i - 1)(j) + sum(i)(j - 1) - sum(i - 1)(j - 1) + mat(i - 1)(j - 1)
      if (i >= len && j >= len && sum(i)(j) - sum(i - len)(j) - sum(i)(j - len) + sum(i - len)(j - len) <= threshold) {
        res = len
        len += 1
      }
    }))
    res
  }
}
