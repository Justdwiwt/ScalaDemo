package leetCode

object Solution_1292 {
  def maxSideLength(mat: Array[Array[Int]], threshold: Int): Int = {
    val dp = Array.fill(mat.length + 1, mat.head.length + 1)(0)
    (1 to mat.length).foreach(i => {
      (1 to mat.head.length).foreach(j => {
        dp(i)(j) = mat(i - 1)(j - 1) + dp(i - 1)(j) + dp(i)(j - 1) - dp(i - 1)(j - 1)
      })
    })
    val len = mat.length.min(mat.head.length)
    (len to 0 by -1).foreach(i => {
      (i to mat.length).foreach(j => {
        (i to mat.head.length).foreach(k => {
          val num = dp(j)(k) - dp(j - i)(k) - dp(j)(k - i) + dp(j - i)(k - i)
          if (num <= threshold) return i
        })
      })
    })
    0
  }
}
