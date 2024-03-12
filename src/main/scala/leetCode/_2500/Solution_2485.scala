package leetCode._2500

object Solution_2485 {
  def pivotInteger(n: Int): Int = {
    val sums = (1 to n).scanLeft(0)(_ + _)
    (0 to n).zip(sums).indexWhere(x => 2 * x._2 == sums.last + x._1)
  }
}
