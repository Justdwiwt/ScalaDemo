package leetCode

object Solution_294 {
  def canWin(s: String): Boolean = {
    s.indices.foreach(i => if (i + 1 < s.length && s(i) == '+' && s(i + 1) == '+') {
      val t = s.toCharArray
      t(i) = '-'
      t(i + 1) = '-'
      if (!canWin(t.mkString)) return true
    })
    false
  }
}
