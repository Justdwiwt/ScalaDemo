package leetCode._2300

object Solution_2250 {
  def countRectangles(rectangles: Array[Array[Int]], points: Array[Array[Int]]): Array[Int] = {
    val minW = rectangles.map(_.head).min
    val maxW = rectangles.map(_.head).max
    val minH = rectangles.map(_(1)).min
    val maxH = rectangles.map(_(1)).max
    points.map(p => {
      if (p.head > maxW || p(1) > maxH) 0
      else if (p.head <= minW && p(1) <= minH) rectangles.length
      else rectangles.count(r => p.head <= r.head && p(1) <= r(1))
    })
  }
}
