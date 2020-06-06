package leetCode

object Solution_1400 {
  def canConstruct(s: String, k: Int): Boolean = {
    if (k > s.length) return false
    val cnt = Array.fill(26)(0)
    s.foreach(i => cnt(i - 'a') += 1)
    var t = 0
    cnt.foreach(i => if ((i & 1) > 0) t += 1)
    if (t <= k) return true
    false
  }
}
