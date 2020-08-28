package leetCode

object Solution_907 {
  def sumSubarrayMins(A: Array[Int]): Int = {
    val M = 1000000007
    val dq = new java.util.ArrayDeque[Int]()
    var res = 0
    (0 to A.length).foreach(i => {
      val cur = if (i == A.length) 0 else A(i)
      while (!dq.isEmpty && A(dq.peek()) > cur) {
        val j = dq.pop()
        val k = if (dq.isEmpty) -1 else dq.peek()
        res = (res + A(j) * (i - j) * (j - k)) % M
      }
      dq.push(i)
    })
    res
  }
}
