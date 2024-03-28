package leetCode._1300

object Solution_1281 {
  def subtractProductAndSum(n: Int): Int = n
    .toString
    .map(_.asDigit)
    .product - n
    .toString
    .map(_.asDigit)
    .sum
}
