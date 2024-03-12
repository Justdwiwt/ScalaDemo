package leetCode._2500

object Solution_2432 {
  def hardestWorker(n: Int, logs: Array[Array[Int]]): Int = {
    val tuples = (0, 0) :: logs.collect { case Array(worker, leave) => (worker, leave) }.toList
    -tuples.zip(tuples.tail).map { case ((_, l1), (w, l2)) => (l2 - l1, -w) }.max._2
  }
}
