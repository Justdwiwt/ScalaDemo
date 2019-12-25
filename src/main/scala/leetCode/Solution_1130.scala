package leetCode

import scala.collection.mutable

object Solution_1130 {
  def mctFromLeafValues(A: Array[Int]): Int = {
    val m = mutable.HashMap[(Int, Int), Int]()
    A.indices.foreach(i => (i + 1 to A.length).foreach(j => {
      val s = A.slice(i, j)
      m.put((i, j - 1), s.max)
    }))
    val dp = Array.fill(A.length, A.length)(1000000000)
    A.indices.foreach(step => A.indices.withFilter(i => i + step < A.length).foreach(i => {
      if (step == 0) dp(i)(i + step) = 0
      else if (step == 1) dp(i)(i + 1) = A(i) * A(i + 1)
      else (i to i + step).withFilter(k => k + 1 <= i + step).foreach(k =>
        dp(i)(i + step) = dp(i)(i + step).min(dp(i)(k) + dp(k + 1)(i + step) + m((i, k)) * m((k + 1, i + step))))
    }))
    dp(0)(A.length - 1)
  }
}
