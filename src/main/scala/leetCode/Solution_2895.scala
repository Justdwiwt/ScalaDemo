package leetCode

object Solution_2895 {
  def minProcessingTime(processorTime: List[Int], tasks: List[Int]): Int = tasks
    .sortBy(-_)
    .zip(processorTime.sorted.flatMap(n => List(n, n, n, n)))
    .map(n => n._2 + n._1)
    .max
}
