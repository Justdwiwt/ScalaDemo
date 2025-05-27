package leetCode._3600

object Solution_3546 {
  def canPartitionGrid(grid: Array[Array[Int]]): Boolean = {
    val sum1 = grid.map(_.map(_.toLong).sum)
    val t1 = sum1.sum
    val sum2 = grid.transpose.map(_.map(_.toLong).sum)
    val t2 = sum2.sum
    sum1.scan(0L)(_ + _).exists(_ * 2 == t1) || sum2.scan(0L)(_ + _).exists(_ * 2 == t2)
  }
}
