package leetCode._3200

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_3161 {
  def getResults(queries: Array[Array[Int]]): List[Boolean] = {
    var m = 0
    queries.foreach(q => m = m.max(q(1)))
    m += 1

    val ts = mutable.TreeSet(0, m)
    val t = Array.fill(2 << (32 - Integer.numberOfLeadingZeros(m)))(0)

    val ans = ListBuffer.empty[Boolean]
    queries.foreach(q => {
      val x = q(1)
      if (q.head == 1) {
        val pre = ts.range(0, x).lastOption.getOrElse(0)
        val nxt = ts.range(x, m).headOption.getOrElse(m)
        ts.add(x)
        update(t, 1, 0, m, x, x - pre)
        update(t, 1, 0, m, nxt, nxt - x)
      } else {
        val pre = ts.range(0, x).lastOption.getOrElse(0)
        val maxGap = query(t, 1, 0, m, pre).max(x - pre)
        ans += (maxGap >= q(2))
      }
    })
    ans.toList
  }

  private def update(t: Array[Int], o: Int, l: Int, r: Int, i: Int, value: Int): Unit = {
    if (l == r) {
      t(o) = value
      return
    }
    val m = (l + r) / 2
    if (i <= m) update(t, o * 2, l, m, i, value)
    else update(t, o * 2 + 1, m + 1, r, i, value)
    t(o) = t(o * 2).max(t(o * 2 + 1))
  }

  private def query(t: Array[Int], o: Int, l: Int, r: Int, R: Int): Int =
    if (r <= R) t(o)
    else {
      val m = (l + r) / 2
      if (R <= m) query(t, o * 2, l, m, R)
      else t(o * 2).max(query(t, o * 2 + 1, m + 1, r, R))
    }
}
