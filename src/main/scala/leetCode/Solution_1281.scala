package leetCode

object Solution_1281 {
  def subtractProductAndSum(n: Int): Int = {
    val t = n.toString.map(_ - '0')
    t.product - t.sum
  }
}
