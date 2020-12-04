package leetCode

object Solution_1540 {
  def canConvertString(s: String, t: String, k: Int): Boolean = {
    if (s.length != t.length) return false
    val arr = Array.fill(26)(0)
    s.indices.foreach(i => {
      var tmp = t(i) - s(i)
      if (tmp < 0) tmp += 26
      arr(tmp) += 1
    })
    (1 until 26).foreach(i => {
      val tmp = i + 26 * (arr(i) - 1)
      if (tmp > k) return false
    })
    true
  }
}
