package leetCode._400

object Solution_391 {
  def isRectangleCover(rectangles: Array[Array[Int]]): Boolean = {
    val res = rectangles
      .flatMap(r => Array((r(0), r(1)), (r(2), r(1)), (r(2), r(3)), (r(0), r(3))).zipWithIndex)
      .groupBy(_._1)
      .values
      .map(_.map(_._2).toSeq)
      .filter(c => c.size > 4 || !Seq(Seq(0, 1, 2, 3), Seq(0, 1), Seq(1, 2), Seq(2, 3), Seq(0, 3)).contains(c.sorted))
    res.size == 4 && res.toSet == (0 to 3).map(Seq(_)).toSet
  }
}
