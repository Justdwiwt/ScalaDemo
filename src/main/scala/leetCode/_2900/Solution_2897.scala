package leetCode._2900

object Solution_2897 {
  def maxSum(A: List[Int], k: Int): Int = {
    val cnt = Array.fill(32)(0)
    A.foreach(a => (0 to 31).foreach(i => if ((a & (1 << i)) != 0) cnt(i) += 1))
    var res = 0L
    val M = 1000000007L
    (0 until k).foreach(j => {
      var cur = 0
      (0 to 31).foreach(i => if (cnt(i) > j) cur += 1 << i)
      res += cur.toLong * cur.toLong % M
      res %= M
    })
    res.toInt
  }
}
