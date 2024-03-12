package leetCode._2600

import scala.collection.mutable

object Solution_2581 {
  private var g = Array.empty[Array[Int]]
  private val st = mutable.HashSet.empty[Long]
  private var t, res, cnt0 = 0

  def rootCount(edges: Array[Array[Int]], guesses: Array[Array[Int]], k: Int): Int = {
    t = k
    g = Array.fill(edges.length + 1)(Array.empty[Int])
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x) :+= y
      g(y) :+= x
    })
    guesses.foreach(e => st += (e.head << 32 | e(1)).toLong)
    dfs(0, -1)
    reroot(0, -1, cnt0)
    res
  }

  private def dfs(x: Int, fa: Int): Unit = {
    g(x).foreach(y => if (y != fa) {
      if (st.contains((x << 32 | y).toLong)) cnt0 += 1
      dfs(y, x)
    })
  }

  private def reroot(x: Int, fa: Int, cnt: Int): Unit = {
    if (cnt >= t) res += 1
    g(x).foreach(y => if (y != fa) {
      var c = cnt
      if (st.contains((x << 32 | y).toLong)) c -= 1
      if (st.contains((y << 32 | x).toLong)) c += 1
      reroot(y, x, c)
    })
  }
}
