package leetCode._400

object Solution_340 {
  def lengthOfLongestSubstringKDistinct(s: String, k: Int): Int = {
    val ch = s.toCharArray
    val cnt = Array.fill(128)(0)
    var res = 0
    var size = 0
    var i = 0
    s.indices.foreach(j => {
      cnt(ch(j)) += 1
      if (cnt(ch(j)) == 1) size += 1
      while (i <= j && size > k) {
        cnt(ch(i)) -= 1
        if (cnt(ch(i)) == 0) size -= 1
        i += 1
      }
      if (i <= j) res = res.max(j - i + 1)
    })
    res
  }
}
