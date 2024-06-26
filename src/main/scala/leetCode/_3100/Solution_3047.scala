package leetCode._3100

object Solution_3047 {
  def largestSquareArea(bottomLeft: Array[Array[Int]], topRight: Array[Array[Int]]): Long = bottomLeft.indices.foldLeft(0L)((max, i) => {
    (i + 1 until topRight.length).foldLeft(max)((res, j) => {
      val minX = bottomLeft(i).head.max(bottomLeft(j).head)
      val maxX = topRight(i).head.min(topRight(j).head)
      val minY = bottomLeft(i)(1).max(bottomLeft(j)(1))
      val maxY = topRight(i)(1).min(topRight(j)(1))
      if (minX >= maxX || minY >= maxY) res
      else {
        val side = (maxX - minX).min(maxY - minY)
        res.max(side.toLong * side)
      }
    })
  })
}
