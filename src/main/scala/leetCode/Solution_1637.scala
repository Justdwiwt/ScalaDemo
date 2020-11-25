package leetCode

object Solution_1637 {
  def maxWidthOfVerticalArea(points: Array[Array[Int]]): Int = {
    points.map(arr => arr(0)).sortWith(_ < _)./:((0, Option.empty[Int])) { (t, v) =>
      (t._1.max(t._2.map(x => v - x).getOrElse(0)), Option(v))
    }._1
  }
}
