package leetCode._2000

object Solution_1956 {
  def minDayskVariants(points: Array[Array[Int]], k: Int): Int = {
    val n = points.length
    if (n < k) return -1
    val cp = points.map { case Array(x, y) => (x + y, x - y) }.sortBy(_._1)
    val minDis = (0 to n - k).flatMap(i => {
      (k to n - i).map(j => {
        val xDis = cp(i + j - 1)._1 - cp(i)._1
        if (xDis < Int.MaxValue) {
          val yAxis = (0 until j).map(t => cp(i + t)._2).sorted
          (0 to j - k).map(t => {
            val yDis = yAxis(t + k - 1) - yAxis(t)
            val yStart = yAxis(t)
            val xStart = cp(i)._1
            var dis = xDis.max(yDis)
            if (dis % 2 == 0 && xDis == yDis && (xStart + yStart) % 2 != 0)
              dis += 1
            dis
          }).reduceOption(_.min(_)).getOrElse(Int.MaxValue)
        } else Int.MaxValue
      })
    }).reduceOption(_.min(_)).getOrElse(Int.MaxValue)
    if (minDis == 0) 0 else (minDis - 1) / 2 + 1
  }
}
