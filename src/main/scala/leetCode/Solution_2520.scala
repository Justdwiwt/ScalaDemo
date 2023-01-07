package leetCode

object Solution_2520 {
  def countDigits(num: Int): Int = num
    .toString
    .count(x => num % (x - '0') == 0)
}
