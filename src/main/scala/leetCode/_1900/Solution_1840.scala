package leetCode._1900

object Solution_1840 {
  def maxBuilding(n: Int, restrictions: Array[Array[Int]]): Int = {
    var bps = List((1, 0))
    restrictions
      .sortBy(_.head)
      .foreach(a => if (a.head - bps.head._1 + bps.head._2 > a(1)) bps = (a.head, a(1)) :: bps)

    @scala.annotation.tailrec
    def f(r: (Int, Int) = (n, -1), res: Int = 0): Int =
      if (bps.isEmpty) res
      else {
        val l = bps.head
        bps = bps.tail
        if (r._2 == -1) f(l, l._2 + (r._1 - l._1))
        else {
          val ex = r._1 - l._1 - (l._2 - r._2).abs
          if (ex > 0) f(l, res.max(l._2.max(r._2) + ex / 2))
          else f(r, res)
        }
      }

    f()
  }
}
