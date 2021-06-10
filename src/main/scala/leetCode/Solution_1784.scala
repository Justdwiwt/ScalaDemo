package leetCode

object Solution_1784 {
  def checkOnesSegment(s: String): Boolean = s
    .dropWhile(_ == '0')
    .reverse
    .dropWhile(_ == '0')
    .toSet == Set('1')
}
