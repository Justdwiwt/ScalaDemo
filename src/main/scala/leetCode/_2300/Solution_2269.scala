package leetCode._2300

object Solution_2269 {
  def divisorSubstrings(num: Int, k: Int): Int = num
    .toString
    .sliding(k)
    .count(s => s.toInt > 0 && num % s.toInt == 0)
}
