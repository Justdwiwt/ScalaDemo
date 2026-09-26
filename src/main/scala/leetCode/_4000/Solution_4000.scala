package leetCode._4000

object Solution_4000 {
  def largestInteger(n: Int, s: Int): Int =
    if (n * 9 < s) -1
    else (0 until n).foldLeft(0 -> s) {
      case ((value, sum), _) =>
        val d = 9.min(sum)
        (value * 10 + d, sum - d)
    }._1
}
