package leetCode

object Solution_392 {
  def isSubsequence(s: String, t: String): Boolean = {
    if (s.length == 0) return true
    if (s.length > t.length) return false
    var v = s.indices.head
    t.indices.withFilter(i => t(i) == s(v)).foreach(_ => {
      v += 1
      if (v > s.indices.last) return true
    })
    false
  }
}
