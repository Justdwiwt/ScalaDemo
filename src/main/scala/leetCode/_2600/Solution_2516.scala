package leetCode._2600

object Solution_2516 {
  def takeCharacters(s: String, k: Int): Int = {
    var j = s.length
    val c = collection.mutable.Map[Char, Int]().withDefaultValue(0)
    var i = 0
    while (c('a') < k || c('b') < k || c('c') < k) {
      if (j == 0) return -1
      j -= 1
      c(s(j)) += 1
    }
    var res = s.length - j
    i = 0
    while (i < s.length) {
      c(s(i)) += 1
      while (j < s.length && c(s(j)) > k) {
        c(s(j)) -= 1
        j += 1
      }
      res = res.min(i + 1 + s.length - j)
      if (j == s.length) return res
      i += 1
    }
    res
  }
}
