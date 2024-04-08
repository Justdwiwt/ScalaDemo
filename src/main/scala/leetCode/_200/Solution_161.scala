package leetCode._200

object Solution_161 {
  @scala.annotation.tailrec
  def isOneEditDistance(s: String, t: String): Boolean =
    if (s.length > t.length) isOneEditDistance(t, s)
    else if (t.length - s.length > 1) false
    else {
      val idx = s.zip(t).indexWhere { case (ch1, ch2) => ch1 != ch2 }
      if (idx == -1) s.length + 1 == t.length
      else if (s.length == t.length) s.substring(idx + 1) == t.substring(idx + 1)
      else s.substring(idx) == t.substring(idx + 1)
    }
}
