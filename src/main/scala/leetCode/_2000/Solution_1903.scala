package leetCode._2000

object Solution_1903 {
  def largestOddNumber(num: String): String = num
    .reverse
    .dropWhile(ch => (ch & 1) == 0)
    .reverse
}
