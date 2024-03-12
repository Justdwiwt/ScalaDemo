package leetCode._500

object Solution_435 {

  case class Interval(start: Int, end: Int)

  object Interval {
    def fromArray(array: Array[Int]): Interval = Interval(start = array(0), end = array(1))

    implicit val ordering: Ordering[Interval] = Ordering.fromLessThan((a, b) => a.end < b.end)
  }

  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.toList.map(Interval.fromArray).sorted
    f(sorted, 0)
  }

  @scala.annotation.tailrec
  def f(sorted: List[Interval], accum: Int): Int = sorted match {
    case Nil | _ :: Nil => accum
    case h :: n :: rest => if (n.start < h.end) f(h :: rest, accum + 1) else f(sorted.tail, accum)
  }

}
