package leetCode

import scala.collection.mutable

object Offer_093 {
  def lenLongestFibSubseq(A: Array[Int]): Int = {
    var res = 0
    val m = new mutable.HashMap[Int, Int]()
    val dp = Array.ofDim[Int](A.length, A.length)
    A.indices.foreach(i => {
      m(A(i)) = i
      (0 until i).foreach(j => {
        val tmp = if (m.contains(A(i) - A(j))) m(A(i) - A(j)) else -1
        dp(j)(i) = if (A(i) - A(j) < A(j) && tmp >= 0) dp(tmp)(j) + 1 else 2
        res = res.max(dp(j)(i))
      })
    })
    if (res > 2) res else 0
  }
}
