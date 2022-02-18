package leetCode

object Solution_2145 {
  def numberOfArrays(differences: Array[Int], lower: Long, upper: Long): Int = {
    val balance = differences.scanLeft(0L)(_ + _)
    val (min, max) = (balance.min, balance.max)
    ((upper - lower) - (max - min) + 1).max(0L).toInt
  }
}
