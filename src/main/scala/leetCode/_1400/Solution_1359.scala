package leetCode._1400

object Solution_1359 {
  def countOrders(n: Int): Int = {
    val factorial = (1 to n).foldLeft(1L)(_ * _ % 1000000007)
    (1 until 2 * n by 2).foldLeft(factorial)(_ * _ % 1000000007).toInt
  }
}
