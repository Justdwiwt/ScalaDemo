package leetCode._1100

object Solution_1039 {
  def minScoreTriangulation(A: Array[Int]): Int = {
    val dp = Array.fill(A.length, A.length)(0)
    A.indices.drop(2).foreach(d => (0 until A.length - d).foreach(i => {
      val j = i + d
      dp(i)(j) = Int.MaxValue
      (i + 1 until j).foreach(k => dp(i)(j) = dp(i)(j).min(dp(i)(k) + dp(k)(j) + A(i) * A(j) * A(k)))
    }))
    dp.head(A.length - 1)
  }
}
