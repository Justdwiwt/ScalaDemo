package leetCode._2200

object Solution_2160 {
  def minimumSum(num: Int): Int = {
    val digits = num.toString.map(_ - '0').sorted
    10 * digits.head + digits(2) + 10 * digits(1) + digits(3)
  }
}
