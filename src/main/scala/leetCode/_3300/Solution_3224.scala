package leetCode._3300

object Solution_3224 {
  def minChanges(nums: Array[Int], k: Int): Int = {
    val n = nums.length
    val cnt = Array.fill(k + 1)(0)
    val cnt2 = Array.fill(k + 1)(0)

    (0 until n / 2).foreach(i => {
      var p = nums(i)
      var q = nums(n - 1 - i)
      if (p > q) {
        val tmp = p
        p = q
        q = tmp
      }
      cnt(q - p) += 1
      cnt2(q.max(k - p)) += 1
    })

    var res = n
    var sum2 = 0

    (0 to k).foreach(x => {
      res = res.min(n / 2 - cnt(x) + sum2)
      sum2 += cnt2(x)
    })

    res
  }
}
