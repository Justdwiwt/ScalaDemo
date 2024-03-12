package leetCode._2600

object Solution_2566 {
  def minMaxDifference(num: Int): Int = {
    lazy val s = num.toString
    lazy val d1 = s.dropWhile(_ == '9').headOption.getOrElse(s.head)
    lazy val d2 = s.dropWhile(_ == '0').headOption.getOrElse(s.head)
    s.map(ch => if (ch == d1) '9' else ch).toInt - s.map(ch => if (ch == d2) '0' else ch).toInt
  }
}
