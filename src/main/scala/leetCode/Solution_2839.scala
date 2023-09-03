package leetCode

object Solution_2839 {
  def canBeEqual(s1: String, s2: String): Boolean = {
    if (s1.length != s2.length) return false
    s1.indices.foreach(i => {
      if (s1.charAt(i) != s2.charAt(i) && s1.charAt(i) != s2.charAt((i + 2) % s1.length())) return false
    })
    true
  }
}
