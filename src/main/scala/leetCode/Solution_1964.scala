package leetCode

object Solution_1964 {
  def longestObstacleCourseAtEachPosition(obstacles: Array[Int]): Array[Int] = {
    val arr = Array.fill(obstacles.length)(0)
    val res = Array.fill(obstacles.length)(0)
    var cnt = 0
    obstacles.indices.foreach(i => {
      var l = 0
      var r = cnt
      val num = obstacles(i)
      while (l < r) {
        val m = (l + r) >>> 1
        if (num < arr(m)) r = m
        else l = m + 1
      }
      arr(r) = num
      res(i) = r + 1
      if (r == cnt) cnt += 1
    })
    res
  }
}
