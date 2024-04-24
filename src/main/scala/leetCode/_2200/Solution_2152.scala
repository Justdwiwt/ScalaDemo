package leetCode._2200

object Solution_2152 {
  def minimumLines(points: Array[Array[Int]]): Int = {
    val n = points.length
    if (n <= 2) 1
    else {
      val res = points.indices.flatMap(i => (i + 1 until n).map(j => {
        val l = points.indices.filter(k => k != i && k != j && !valid(points, i, j, k)).map(k => Array(points(k).head, points(k)(1)))
        if (l.isEmpty) 1
        else if (l.length == 1) 2
        else 1 + minimumLines(l.toArray)
      })).min
      res
    }
  }

  private def valid(points: Array[Array[Int]], a: Int, b: Int, c: Int): Boolean =
    0 == (points(a).head - points(b).head) * (points(a)(1) - points(c)(1)) - (points(a)(1) - points(b)(1)) * (points(a).head - points(c).head)
}
