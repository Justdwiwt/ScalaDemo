package leetCode._3100

object Solution_3047 {
  def largestSquareArea(bottomLeft: Array[Array[Int]], topRight: Array[Array[Int]]): Long = {
    var res = 0L
    bottomLeft.indices.foreach(i => {
      val b1 = bottomLeft(i)
      val t1 = topRight(i)
      (i + 1 until bottomLeft.length).foreach(j => {
        val b2 = bottomLeft(j)
        val t2 = topRight(j)
        val height = t1(1).min(t2(1)) - b1(1).max(b2(1))
        val width = t1.head.min(t2.head) - b1.head.max(b2.head)
        val size = width.min(height)
        if (size > 0) res = res.max((size * size).toLong)
      })
    })
    res
  }
}
