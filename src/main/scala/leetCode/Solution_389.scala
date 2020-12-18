package leetCode

object Solution_389 {
  def findTheDifference(s: String, t: String): Char = {
    (t.map(_.toInt).sum - s.map(_.toInt).sum).toChar
  }
}
