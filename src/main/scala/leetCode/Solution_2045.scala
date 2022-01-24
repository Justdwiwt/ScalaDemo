package leetCode

import java.util

object Solution_2045 {
  def secondMinimum(n: Int, edges: Array[Array[Int]], time: Int, change: Int): Int = {
    val arr = Array.fill(n)(Array.empty[Int])
    val diff = Array.fill(n, 2)(0)
    edges.foreach(e => {
      var v = e.head - 1
      val u = e(1) - 1
      arr(v) :+= u
      arr(u) :+= v
    })
    (1 until n).foreach(i => {
      diff(i)(0) = Int.MaxValue
      diff(i)(1) = Int.MaxValue
    })
    diff.head(1) = Int.MaxValue
    val q = new util.LinkedList[Array[Int]]()
    q.offer(Array(0, 0))
    while (!q.isEmpty) {
      val now = q.poll()
      val head = now.head
      val path = now(1)
      arr(head).foreach(u => {
        if (diff(u).head > path + 1) {
          diff(u)(0) = path + 1
          q.offer(Array(u, diff(u).head))
        } else if ((diff(u).head < path + 1) && (diff(u)(1) > path + 1)) {
          diff(u)(1) = path + 1
          q.offer(Array(u, diff(u)(1)))
        }
      })
    }
    val res = diff(n - 1)(1)
    f(res, time, change)
  }

  def f(len: Int, time: Int, change: Int): Int = {
    var res = 0
    import scala.util.control.Breaks._
    breakable {
      (0 until len).foreach(i => {
        res += time
        if (i == len - 1) break()
        val p = res / change
        if ((p & 1) == 1) res = (p + 1) * change
      })
    }
    res
  }
}
