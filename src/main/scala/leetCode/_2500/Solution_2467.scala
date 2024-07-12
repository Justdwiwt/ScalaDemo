package leetCode._2500

import scala.collection.mutable.ArrayBuffer

// fixme: case 29/31 stack overflow
object Solution_2467 {
  def mostProfitablePath(edges: Array[Array[Int]], bob: Int, amount: Array[Int]): Int = {
    val n = amount.length
    val arr = Array.fill(n)(ArrayBuffer[Int]())

    edges.foreach { case Array(u, v) =>
      arr(u).append(v)
      arr(v).append(u)
    }

    val INF = Int.MaxValue / 2

    def dfs(p: Int, i: Int, h: Int): (Int, Int) = {
      var reward = -INF
      var steps = if (i == bob) 0 else INF

      arr(i).foreach(nxt => {
        if (nxt != p) {
          val (r, bobDist) = dfs(i, nxt, h + 1)
          steps = steps.min(bobDist + 1)
          reward = reward.max(r)
        }
      })

      if (reward == -INF) reward = 0

      if (steps == h) reward += amount(i) / 2
      else if (steps > h) reward += amount(i)

      (reward, steps)
    }

    dfs(-1, 0, 0)._1
  }
}
