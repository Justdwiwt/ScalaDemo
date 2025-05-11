package leetCode._3600

object Solution_3536 {
  def maxProduct(n: Int) = n
    .toString
    .map(_.toInt - 0x30)
    .sortWith(_ > _)
    .take(2)
    .product
}
