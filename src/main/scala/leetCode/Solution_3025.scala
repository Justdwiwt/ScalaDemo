package leetCode

object Solution_3025 {
  def numberOfPairs(points: Array[Array[Int]]): Int = {
    java.util.Arrays.sort(points, (a: Array[Int], b: Array[Int]) => {
      if (a.head != b.head) return a.head - b.head
      else return b(1) - a(1)
    })
    var res = 0
    points.indices.foreach(i => {
      val y0 = points(i)(1)
      var mxY = Int.MinValue
      (i + 1 until points.length).foreach(j => {
        val y = points(j)(1)
        if (y <= y0 && y > mxY) {
          mxY = y
          res += 1
        }
      })
    })
    res
  }
}
