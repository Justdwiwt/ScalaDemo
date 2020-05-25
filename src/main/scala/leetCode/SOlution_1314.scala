package leetCode

object SOlution_1314 {
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    val res = Array.ofDim[Int](mat.length, mat(0).length)
    val dp = Array.ofDim[Int](mat.length + 1, mat(0).length + 1)
    mat.indices.foreach(i => mat(0).indices.foreach(j => dp(i + 1)(j + 1) = dp(i)(j + 1) + dp(i + 1)(j) - dp(i)(j) + mat(i)(j)))
    mat.indices.foreach(i => mat(0).indices.foreach(j => {
      val r1 = (i - K).max(0)
      val c1 = (j - K).max(0)
      val r2 = (i + K).min(mat.length - 1)
      val c2 = (j + K).min(mat(0).length - 1)
      res(i)(j) = dp(r2 + 1)(c2 + 1) - dp(r1)(c2 + 1) - dp(r2 + 1)(c1) + dp(r1)(c1)
    }))
    res
  }
}
