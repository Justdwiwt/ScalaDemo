package leetCode._700

object Solution_678 {
  def checkValidString(s: String): Boolean = {
    var p = 0
    var q = 0
    s.foreach({
      case '(' =>
        p += 1
        q += 1
      case ')' =>
        p = 0.max(p - 1)
        q -= 1
        if (q < 0) return false
      case _ =>
        p = (p - 1).max(0)
        q += 1
    })
    p <= 0
  }
}
