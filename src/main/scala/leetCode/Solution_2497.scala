package leetCode

object Solution_2497 {
  implicit val ord: Ordering[Long] = Ordering.Long

  def maxStarSum(vals: Array[Int], edges: Array[Array[Int]], k: Int): Int = {
    val bestEdges = edges./:(Map.empty[Int, Array[Int]].withDefaultValue(Array.empty)) {
      case (bestEdges, Array(a, b)) => bestEdges
        .updated(a, bestEdges(a) :+ vals(b))
        .updated(b, bestEdges(b) :+ vals(a))
    }
    vals
      .zipWithIndex
      .map { case (value, node) => bestEdges(node).sorted.takeRight(k).filter(_ > 0).sum + value }
      .max
  }
}
