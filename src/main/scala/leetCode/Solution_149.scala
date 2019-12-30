package leetCode

object Solution_149 {
  def maxPoints(points: Array[Array[Int]]): Int = {
    var mx = 0
    if (points.length < 3) return points.length
    points.indices.foreach(i => {
      var flag = 1
      (i + 1 until points.length).foreach(j => {
        var cnt = 0
        if (points(i)(0) == points(j)(0) && points(i)(1) == points(j)(1)) flag += 1
        else {
          cnt += 1
          val x = (points(i)(0) - points(j)(0)).toLong
          val y = (points(i)(1) - points(j)(1)).toLong
          (j + 1 until points.length).foreach(k =>
            if (x * (points(i)(1) - points(k)(1)) == y * (points(i)(0) - points(k)(0))) cnt += 1)
        }
        mx = mx.max(flag + cnt)
      })
      if (mx > points.length / 2) return mx
    })
    mx
  }
}
