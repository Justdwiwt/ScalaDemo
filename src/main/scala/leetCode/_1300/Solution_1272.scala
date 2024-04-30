package leetCode._1300

object Solution_1272 {
  def removeInterval(intervals: Array[Array[Int]], toBeRemoved: Array[Int]): List[List[Int]] = {
    val res = new scala.collection.mutable.ListBuffer[List[Int]]()
    intervals.foreach(interval =>
      if (interval(0) > toBeRemoved(1) || interval(1) < toBeRemoved(0))
        res += List(interval(0), interval(1))
      else {
        if (interval(0) < toBeRemoved(0))
          res += List(interval(0), toBeRemoved(0))
        if (interval(1) > toBeRemoved(1))
          res += List(toBeRemoved(1), interval(1))
      })
    res.toList
  }
}
