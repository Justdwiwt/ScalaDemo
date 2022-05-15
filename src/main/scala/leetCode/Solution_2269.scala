package leetCode

object Solution_2269 {
  def divisorSubstrings(num: Int, k: Int): Int = num
    .toString
    .sliding(k)
    .count(s => {
      val x = s.toInt
      x != 0 && num % x == 0
    })
}
