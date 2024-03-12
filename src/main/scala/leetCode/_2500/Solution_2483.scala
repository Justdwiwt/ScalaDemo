package leetCode._2500

object Solution_2483 {
  def bestClosingTime(customers: String): Int = {
    val y = customers.map(n => if (n == 'Y') 1 else 0).mkString.toList.map(_.asDigit).scanRight(0)(_ + _)
    val n = customers.map(n => if (n == 'N') 1 else 0).mkString.toList.map(_.asDigit).scanLeft(0)(_ + _)
    y.zip(n).map(n => n._2 + n._1).zipWithIndex.minBy(n => (n._1, n._2))._2
  }
}
