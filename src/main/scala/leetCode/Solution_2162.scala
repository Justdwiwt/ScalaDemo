package leetCode

object Solution_2162 {
  def minCostSetTime(startAt: Int, moveCost: Int, pushCost: Int, targetSeconds: Int): Int = {
    @scala.annotation.tailrec
    def f(start: Int, ds: Seq[Int], acc: Int): Int = {
      lazy val (h, t) = (ds.head, ds.tail)
      lazy val newAcc = acc + (if (start != h) moveCost + pushCost else pushCost)
      if (ds.isEmpty) acc
      else f(h, t, newAcc)
    }

    val (m, s) = (targetSeconds / 60, targetSeconds % 60)
    val filtered = Seq((m, s), (m - 1, s + 60)).filter({ case (m, s) => (m >= 0) && (m < 100) && (s < 100) })
    filtered.map({ case (m, s) =>
      val ms = m.toString
      val ss = ("0" + s.toString).takeRight(2)
      val digs = (ms + ss).dropWhile(_ == '0').map(_ - '0')
      f(startAt, digs, 0)
    }).min
  }
}
