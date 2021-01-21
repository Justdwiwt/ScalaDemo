package leetCode

object Solution_1725 {
  def countGoodRectangles(rectangles: Array[Array[Int]]): Int = rectangles
    .map(_.min)
    .groupBy(x => x)
    .toArray
    .maxBy(_._1)
    ._2
    .length
}
