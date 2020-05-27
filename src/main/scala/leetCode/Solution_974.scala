package leetCode

object Solution_974 {
  def subarraysDivByK(A: Array[Int], K: Int): Int = {
    val arr = Array.fill(K)(0)
    arr(0) += 1
    var pre = 0
    var res = 0
    A.foreach(i => {
      pre = (i + pre) % K
      if (pre < 0) pre += K
      res += arr(pre)
      arr(pre) += 1
    })
    res
  }
}
