package leetCode._2200

import scala.collection.mutable.ListBuffer

object Solution_2152 {
  def minimumLines(points: Array[Array[Int]]): Int = {
    val n = points.length
    if (n <= 2) 1
    else {
      var res = n
      (0 until n).foreach(i => (i + 1 until n).foreach(j => {
        val l = ListBuffer.empty[Array[Int]]
        (0 until n).foreach(k => if (k != i && k != j && !valid(points, i, j, k)) l += Array(points(k).head, points(k)(1)))
        if (l.isEmpty) res = 1
        else if (l.length == 1) res = res.min(2)
        else {
          val minLines = minimumLines(l.toArray)
          res = res.min(1 + minLines)
        }
      }))
      res
    }
  }

  private def valid(points: Array[Array[Int]], a: Int, b: Int, c: Int): Boolean =
    0 == (points(a).head - points(b).head) * (points(a)(1) - points(c)(1)) - (points(a)(1) - points(b)(1)) * (points(a).head - points(c).head)
}
