package leetCode._3400

object Solution_3386 {
  def buttonWithLongestTime(events: Array[Array[Int]]): Int = (Array(Array(0, 0)).iterator ++ events.iterator)
    .sliding(2)
    .collect { case Seq(Array(_, t1), Array(id, t2)) => (id, t2 - t1) }
    .maxBy(x => (x._2, -x._1))
    ._1
}
