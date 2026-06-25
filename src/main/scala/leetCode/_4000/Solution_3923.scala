package leetCode._4000

object Solution_3923 {
  def minGenerations(points: Array[Array[Int]], target: Array[Int]): Int = {
    val tar = (target(0), target(1), target(2))

    @scala.annotation.tailrec
    def f(cur: Set[(Int, Int, Int)], step: Int): Int =
      if (cur(tar)) step
      else {
        val nxt = cur ++ cur.subsets(2).map { s =>
          val Array((x, y, z), (a, b, c)) = s.toArray
          ((x + a) / 2, (y + b) / 2, (z + c) / 2)
        }

        if (nxt.size == cur.size) -1
        else f(nxt, step + 1)
      }

    f(points.map(p => (p(0), p(1), p(2))).toSet, 0)
  }
}
