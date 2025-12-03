package leetCode._3700

object Solution_3625 {
  def countTrapezoids(points: Array[Array[Int]]): Int = {
    @scala.annotation.tailrec
    def gcd(a: Int, b: Int): Int =
      if (b == 0) math.abs(a) else gcd(b, a % b)

    val segments = points
      .indices
      .flatMap(i => ((i + 1) until points.length).map(j => {
        val dx0 = points(j)(0) - points(i)(0)
        val dy0 = points(j)(1) - points(i)(1)

        val (dx, dy) =
          if (dx0 < 0 || (dx0 == 0 && dy0 < 0)) (-dx0, -dy0)
          else (dx0, dy0)

        val g = gcd(dx, dy.abs)
        val sx = dx / g
        val sy = dy / g

        val des = sx * points(i)(1) - sy * points(i)(0)

        val keyNorm = (sx << 12) | (sy + 2000)
        val keyRaw = (dx << 12) | (dy + 2000)

        ((keyNorm, des), (keyRaw, des))
      }))

    def buildCountMap[K](pairs: Seq[(K, Int)]): Map[K, Map[Int, Int]] = pairs
      .groupBy(_._1)
      .map { case (k, list) =>
        val inner = list
          .groupBy(_._2)
          .map { case (des, arr) => des -> arr.size }
        k -> inner
      }

    val tMap = buildCountMap(segments.map(_._1))
    val vMap = buildCountMap(segments.map(_._2))

    def count(map: Map[Int, Map[Int, Int]]): Long = map
      .values
      .foldLeft(0L)((acc, inner) => {
        val values = inner.values.toList
        val sum = values.sum.toLong
        val pairs = values.foldLeft((0L, sum)) {
          case ((ans, remain), v) =>
            (ans + v * (remain - v), remain - v)
        }._1
        acc + pairs
      })

    val cntT = count(tMap)
    val cntV = count(vMap)

    (cntT - cntV / 2).toInt
  }
}
