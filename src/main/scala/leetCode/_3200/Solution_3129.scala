package leetCode._3200

object Solution_3129 {
  var memo: Array[Array[Array[Int]]] = _
  var k: Int = _
  var M = 1000000007

  def numberOfStableArrays(zero: Int, one: Int, limit: Int): Int = {
    k = limit + 1
    memo = Array.ofDim(zero + 1, one + 1, 2)
    memo.foreach(_.foreach(b => b.indices.foreach(b(_) = -1)))

    (dfs(zero, one, 0) + dfs(zero, one, 1)) % M
  }

  private def dfs(u: Int, v: Int, pre: Int): Int = {
    if (u < 0 || v < 0) return 0
    if (u == 0 && v == 0) return 1
    if (memo(u)(v)(pre) != -1) return memo(u)(v)(pre)

    var res = 0L
    (1 until k).foreach(i => res += dfs(u - i * (1 - pre), v - i * pre, pre ^ 1))

    memo(u)(v)(pre) = (res % M).toInt
    memo(u)(v)(pre)
  }
}
