package leetCode._2700

object Solution_2615 {
  def distance(nums: Array[Int]): Array[Long] = {
    def f(input: Array[Int], acc: Array[Long]): Array[(Int, Long)] = input
      .zipWithIndex
      .map(n => (n._1, n._2 * n._1.toLong - acc(n._2) + acc.last - acc(n._2) - (input.length - n._2) * n._1.toLong))

    nums
      .zipWithIndex
      .groupBy(_._1)
      .mapValues(_.map(_._2))
      .values
      .flatMap(n => f(n.sorted, n.sorted.scanLeft(0L)(_ + _)))
      .toArray
      .sorted
      .map(_._2)
  }
}
