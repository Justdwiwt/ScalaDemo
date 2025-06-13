package leetCode._3600

object Solution_3563 {
  private def rp(c: Char, d: Char): Boolean = {
    val x = (c - d).abs
    x == 1 || x == 25
  }

  private def ir(s: String, l: Int, r: Int, m: collection.mutable.Map[(Int, Int), Boolean]): Boolean = {
    if (l > r) return true
    if (((r - l + 1) & 1) == 1) return false
    if (m.contains((l, r))) return m((l, r))
    var rbl = false
    var j = l + 1
    while (j <= r && !rbl) {
      if (ir(s, l + 1, j - 1, m) && rp(s(l), s(j)) && ir(s, j + 1, r, m)) rbl = true
      j += 1
    }
    m((l, r)) = rbl
    rbl
  }

  private def cl(a: Option[String], b: Option[String]): Option[String] = (a, b) match {
    case (None, x) => x
    case (x, None) => x
    case (Some(x), Some(y)) => if (x < y) Some(x) else Some(y)
  }

  private def gc(s: String, i: Int, j: Int, n: Int, d: collection.mutable.Map[Int, Option[String]], m: collection.mutable.Map[(Int, Int), Boolean]): Option[String] = {
    val cnd = if (j == i) true else ir(s, i, j - 1, m)
    if (!cnd) return None
    val rec = dp(s, j + 1, n, d, m)
    rec match {
      case Some(x) => Some(s(j).toString + x)
      case None => None
    }
  }

  private def dp(s: String, i: Int, n: Int, d: collection.mutable.Map[Int, Option[String]], m: collection.mutable.Map[(Int, Int), Boolean]): Option[String] = {
    if (i >= n) return Some("")
    if (d.contains(i)) return d(i)
    if (ir(s, i, n - 1, m)) {
      d(i) = Some("")
      return Some("")
    }
    var res: Option[String] = None
    var j = i
    while (j < n) {
      val cand = gc(s, i, j, n, d, m)
      if (cand.isDefined) res = cl(res, cand)
      j += 1
    }
    d(i) = res
    res
  }

  def lexicographicallySmallestString(s: String): String = {
    val n = s.length
    val m = collection.mutable.Map[(Int, Int), Boolean]()
    val d = collection.mutable.Map[Int, Option[String]]()
    dp(s, 0, n, d, m).getOrElse(s)
  }
}
