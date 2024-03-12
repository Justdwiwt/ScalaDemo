package leetCode._1100

object Solution_1100 {
  def numKLenSubstrNoRepeats(s: String, k: Int): Int = {
    val cnt = Array.fill(26)(0)
    var res = 0
    var l = 0
    s.indices.foreach(r => {
      cnt(s(r) - 'a') += 1
      while (cnt(s(r) - 'a') > 1 || l <= r - k) {
        cnt(s(l) - 'a') -= 1
        l += 1
      }
      if (r - l + 1 == k) res += 1
    })
    res
  }
}
