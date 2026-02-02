package leetCode._3800

object Solution_3798 {
  def largestEven(s: String): String =
    s.reverse.dropWhile(_ == '1').reverse
}
