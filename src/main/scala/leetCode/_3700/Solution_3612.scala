package leetCode._3700

object Solution_3612 {
  def processStr(s: String): String =
    s.foldLeft("") { case (res, c) =>
      if (c.isLower) res + c
      else if (c == '*') if (res.nonEmpty) res.dropRight(1) else res
      else if (c == '#') res + res
      else res.reverse
    }
}
