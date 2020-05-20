package leetCode

object Solution_1371 {
  def findTheLongestSubstring(s: String): Int = {
    var res = 0
    var status = 0
    val diff = Array.fill(32)(-1)
    diff(0) = 0
    s.indices.foreach(i => {
      s(i) match {
        case 'a' => status ^= 1 << 0
        case 'e' => status ^= 1 << 1
        case 'i' => status ^= 1 << 2
        case 'o' => status ^= 1 << 3
        case 'u' => status ^= 1 << 4
        case _ =>
      }
      if (diff(status) != -1) res = res.max(i + 1 - diff(status))
      else diff(status) = i + 1
    })
    res
  }
}
