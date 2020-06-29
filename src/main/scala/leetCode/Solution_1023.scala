package leetCode

object Solution_1023 {
  def camelMatch(queries: Array[String], pattern: String): Array[Boolean] = {
    var res = Array.empty[Boolean]
    queries.foreach(i => res :+= check(i, pattern))
    res
  }

  def check(s1: String, s2: String): Boolean = {
    var idx = 0
    s1.indices.foreach(i => {
      if (idx < s2.length && s1(i) == s2(idx)) idx += 1
      else if (s1(i) >= 'A' && s1(i) <= 'Z') return false
    })
    idx == s2.length
  }
}
