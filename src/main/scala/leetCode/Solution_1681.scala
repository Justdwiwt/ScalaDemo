package leetCode

object Solution_1681 {
  def minimumIncompatibility(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    val m = 1 << n
    val q = n / k

    if (n % k != 0) return -1

    var cnt = Array.fill(n + 1)(0)
    nums.foreach(n => {
      cnt(n) += 1
      if (cnt(n) > k) return -1
    })

    val INF = 0x3f3f3f3f
    var list = Array.empty[Array[Int]]
    var tot = Array.empty[Int]

    (1 until m).foreach(i => {
      cnt = Array.fill(cnt.length)(0)
      var success = true
      var t = 0
      var mx = 0
      var mn = n + 1
      nums.indices.foreach(j => {
        if ((i >> j & 1) == 1) {
          cnt(nums(j)) += 1
          if (cnt(nums(j)) > 1) success = false
          mx = mx.max(nums(j))
          mn = mn.min(nums(j))
          t += 1
        }
      })

      if (success && t == q) list :+= Array(i, mx - mn)
      if (t % q == 0) tot :+= i
    })

    val dp = Array.fill(m)(0)
    (1 until m).foreach(i => dp(i) = INF)
    list.foreach(in => {
      val v = in.head
      val w = in(1)
      tot.indices.reverse.foreach(i => {
        val s = tot(i)
        if ((s & v) == v) dp(s) = dp(s).min(dp(s ^ v) + w)
      })
    })

    if (dp(m - 1) >= INF) -1 else dp(m - 1)
  }
}
