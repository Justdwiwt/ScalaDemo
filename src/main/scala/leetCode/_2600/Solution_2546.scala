package leetCode._2600

object Solution_2546 {
  def makeStringsEqual(s: String, target: String): Boolean =
    s.exists(_ == '1') == target.exists(_ == '1')
}
