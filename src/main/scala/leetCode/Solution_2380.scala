package leetCode

object Solution_2380 {
  def secondsToRemoveOccurrences(s: String): Int = Iterator
    .iterate(s)(_.replace("01", "10"))
    .takeWhile(s => !s.startsWith(s.filter(_ == '1')))
    .length
}
