package leetCode._3300

object Solution_3216 {
  def getSmallestString(s: String): String = s
    .toCharArray
    .sliding(2)
    .zipWithIndex
    .collectFirst { case (Array(x, y), i) if x > y && x % 2 == y % 2 => (x, y, i) }
    .map { case (x, y, i) =>
      val updatedArray = s.toCharArray
      updatedArray(i) = y
      updatedArray(i + 1) = x
      new String(updatedArray)
    }
    .getOrElse(s)
}
