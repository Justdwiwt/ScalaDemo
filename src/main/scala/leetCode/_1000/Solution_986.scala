package leetCode._1000

object Solution_986 {

  case class Interval(start: Int, end: Int)

  def intervalIntersection(firstList: Array[Array[Int]], secondList: Array[Array[Int]]): Array[Array[Int]] = {
    val first = firstList.toList.map({ case Array(st, en) => Interval(st, en) })
    val second = secondList.toList.map({ case Array(st, en) => Interval(st, en) })
    merge(first, second).map({ case Interval(a, b) => Array(a, b) }).toArray
  }

  def merge(a: List[Interval], b: List[Interval]): List[Interval] = (a, b) match {
    case (Interval(aStart, aEnd) :: _, Interval(bStart, bEnd) :: _) =>
      val lo = aStart.max(bStart)
      val hi = aEnd.min(bEnd)
      val res = if (aEnd < bEnd) merge(a.tail, b) else merge(a, b.tail)
      if (lo <= hi) Interval(lo, hi) :: res else res
    case _ => Nil
  }

}
