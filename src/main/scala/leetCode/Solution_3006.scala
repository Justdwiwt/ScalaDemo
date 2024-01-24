package leetCode

object Solution_3006 {
  def beautifulIndices(s: String, a: String, b: String, k: Int): List[Int] = {
    var res = Array.empty[Int]
    val l1 = kmp(s, a)
    val l2 = kmp(s, b)
    var i = -1
    l1.foreach(idx => {
      while (i + 1 < l2.length && l2(i + 1) <= idx + k) i += 1
      if (i >= 0 && (idx - l2(i)).abs <= k) res :+= idx
    })
    res.toList
  }

  def kmp(text: String, pattern: String): List[Int] = {
    var res = Array.empty[Int]
    val s = text.toCharArray
    val p = pattern.toCharArray
    val n = pattern.length
    val m = s.length
    val next = Array.fill(n + 1)(0)
    var i = 2
    var j = 0
    while (i <= n) {
      while (j > 0 && p(i - 1) != p(j)) j = next(j)
      if (p(i - 1) == p(j)) j += 1
      i += 1
    }
    var x = 1
    var y = 0
    while (x <= m) {
      while (y > 0 && s(x - 1) != p(y)) y = next(y)
      if (s(i - 1) == p(y)) y += 1
      if (y == n) {
        res :+= (x - n)
        y = next(y)
      }
      x += 1
    }
    res.toList
  }
}
