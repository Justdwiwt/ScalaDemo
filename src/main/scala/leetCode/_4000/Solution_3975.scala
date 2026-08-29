package leetCode._4000

object Solution_3975 {
  def filterOccupiedIntervals(occupiedIntervals: Array[Array[Int]], freeStart: Int, freeEnd: Int): List[List[Int]] = {
    val buf = collection.mutable.ArrayBuffer.empty[Array[Int]]

    occupiedIntervals
      .flatMap {
        case p@Array(s, e) if e < freeStart || s > freeEnd => Seq(p)
        case Array(s, e) if s < freeStart && e > freeEnd => Seq(Array(s, freeStart - 1), Array(freeEnd + 1, e))
        case Array(s, e) if e >= freeStart && s < freeStart => Seq(Array(s, freeStart - 1))
        case Array(s, e) if s <= freeEnd && e > freeEnd => Seq(Array(freeEnd + 1, e))
        case _ => Seq.empty
      }
      .sortWith {
        case (Array(a, _), Array(b, _)) => a < b
        case _ => false
      }
      .foreach {
        case p@Array(_, _) if buf.isEmpty => buf += p
        case p@Array(s, e) =>
          val last = buf.last
          if (s <= last(1) + 1) last(1) = e.max(last(1))
          else buf += p
      }

    buf.map(_.toList).toList
  }
}
