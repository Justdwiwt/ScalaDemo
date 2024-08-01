package leetCode._3300

object Solution_3234 {
  def numberOfSubstrings(S: String): Int = {
    val s = S.toCharArray
    var res = 0
    var tot1 = 0
    val arr = Array.fill(s.length + 1)(-1)
    var m = 1

    s.indices.foreach(right => {
      if (s(right) == '0') {
        arr(m) = right
        m += 1
      } else {
        res += right - arr(m - 1)
        tot1 += 1
      }
      var k = m - 1
      while (k > 0 && (m - k) * (m - k) <= tot1) {
        val cnt0 = m - k
        val cnt1 = right - arr(k) + 1 - cnt0
        res += 0.max(arr(k) - arr(k - 1) - 0.max(cnt0 * cnt0 - cnt1))
        k -= 1
      }
    })

    res
  }
}
