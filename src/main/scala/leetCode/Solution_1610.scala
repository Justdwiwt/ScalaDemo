package leetCode

object Solution_1610 {
  def visiblePoints(points: List[List[Int]], angle: Int, location: List[Int]): Int = {
    var angles = Array.emptyDoubleArray
    var cnt = 0
    points.foreach(p => {
      val dx = p.head - location.head
      val dy = p(1) - location(1)
      if (dx == 0 && dy == 0) cnt += 1
      else {
        var degree = math.atan2(dy, dx) * (180 / math.Pi)
        angles :+= degree
      }
    })
    angles = angles.sorted
    angles.indices.foreach(i => angles :+= (angles(i) + 360))
    var begin = 0
    var res = 0
    angles.indices.foreach(end => {
      while (angles(end) - angles(begin) > angle) begin += 1
      res = res.max(end - begin + 1)
    })
    res += cnt
    res
  }
}
