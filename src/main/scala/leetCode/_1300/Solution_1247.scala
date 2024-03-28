package leetCode._1300

object Solution_1247 {
  def minimumSwap(s1: String, s2: String): Int = {
    lazy val diff = s1.zip(s2).collect { case (a, b) if a != b => a }
    if (diff.size % 2 != 0) -1
    else diff.size / 2 + diff.count(_ == 'x') % 2
  }
}
