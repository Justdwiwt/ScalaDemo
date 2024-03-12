package leetCode._200

object Solution_161 {
  def isOneEditDistance(s: String, t: String): Boolean = {
    if (s.length > t.length) return isOneEditDistance(t, s)
    if (t.length - s.length > 1) return false
    s.indices.foreach(i => {
      if (s(i) != t(i))
        if (s.length == t.length) return s.substring(i + 1).equals(t.substring(i + 1))
        else return s.substring(i).equals(t.substring(i + 1))
    })
    s.length + 1 == t.length
  }
}
