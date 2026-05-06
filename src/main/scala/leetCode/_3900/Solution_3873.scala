package leetCode._3900

object Solution_3873 {
  def maxActivated(points: Array[Array[Int]]): Int = {
    val OFFSET = 3000000000L

    def find(x: Long, fa: Map[Long, Long]): (Long, Map[Long, Long]) = fa.get(x) match {
      case None => (x, fa)
      case Some(p) if p == x => (x, fa)
      case Some(p) =>
        val (root, fa2) = find(p, fa)
        (root, fa2.updated(x, root))
    }

    val finalFa = points.foldLeft(Map.empty[Long, Long]) { (fa, p) =>
      val x = p(0).toLong
      val y = p(1).toLong + OFFSET

      val (rx, fa1) = find(x, fa)
      val (ry, fa2) = find(y, fa1)

      if (rx != ry) fa2.updated(rx, ry) else fa2
    }

    val (cntMap, _) = points.foldLeft((Map.empty[Long, Int], finalFa)) {
      case ((cnt, fa), p) =>
        val x = p(0).toLong
        val (root, fa2) = find(x, fa)
        (cnt.updated(root, cnt.getOrElse(root, 0) + 1), fa2)
    }

    val (mx1, mx2) = cntMap.values.foldLeft((0, 0)) {
      case ((a, b), sz) =>
        if (sz > a) (sz, a)
        else if (sz > b) (a, sz)
        else (a, b)
    }

    mx1 + mx2 + 1
  }
}
