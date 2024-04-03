package leetCode._700

object Solution_699 {
  def fallingSquares(positions: Array[Array[Int]]): List[Int] = positions.scanLeft(List[(Int, Int, Int)]()) {
    case (interval, Array(s, h)) =>
      interval.filter(i => !(i._2 <= s || s + h <= i._1)) match {
        case Nil => (s, s + h, h) +: interval
        case x => (s, s + h, h + x.maxBy(_._3)._3) +: interval
      }
    case _ => Nil
  }.tail.map(_.maxBy(_._3)._3).toList
}
