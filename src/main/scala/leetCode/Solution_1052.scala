package leetCode

object Solution_1052 {
  def maxSatisfied(customers: Array[Int], grumpy: Array[Int], X: Int): Int = {
    var p = 0
    var cnt = 0
    var mxCnt = 0
    grumpy.indices.foreach(i => {
      if (grumpy(i) == 0) cnt += customers(i)
      else p += customers(i)
      if (i >= X) p -= grumpy(i - X) * customers(i - X)
      mxCnt = mxCnt.max(p)
    })
    cnt + mxCnt
  }
}
