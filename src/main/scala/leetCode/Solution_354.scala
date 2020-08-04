package leetCode

object Solution_354 {
  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
    if (envelopes == null || envelopes.isEmpty) return 0
    val arr = envelopes.sorted((a: Array[Int], b: Array[Int]) => if (a(0) != b(0)) return a(0) - b(0) else return b(1) - a(1))
    val dp = Array.fill(envelopes.length)(0)
    var res = 0
    arr.indices.foreach(i => {
      var idx = java.util.Arrays.binarySearch(dp, 0, res, arr(i)(1))
      if (idx < 0) idx = -idx - 1
      dp(idx) = arr(i)(1)
      if (idx == res) res += 1
    })
    res
  }
}
