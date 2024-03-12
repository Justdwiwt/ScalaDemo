package leetCode._100

object Solution_57 {
  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val (acc, last) = intervals./:((Array.empty[Array[Int]], newInterval)) {
      case ((rest, newInterval), head) =>
        if (newInterval.last < head.head) (rest :+ newInterval, head)
        else if (newInterval.head > head.last) (rest :+ head, newInterval)
        else (rest, Array(head.head.min(newInterval.head), head.last.max(newInterval.last)))
    }
    acc :+ last
  }
}
