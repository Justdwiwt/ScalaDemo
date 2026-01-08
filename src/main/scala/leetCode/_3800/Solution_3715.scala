package leetCode._3800

import scala.collection.mutable

object Solution_3715 {
  def sumOfAncestors(n: Int, edges: Array[Array[Int]], nums: Array[Int]): Long = {
    val MX = 100001
    val core = Array.fill(MX)(0)
    (1 until MX).foreach(i => {
      if (core(i) == 0) {
        var j = 1
        while (i * j * j < MX) {
          core(i * j * j) = i
          j += 1
        }
      }
    })

    val g = Array.fill(n)(List.empty[Int])
    edges.foreach(e => {
      val x = e(0)
      val y = e(1)
      g(x) = y :: g(x)
      g(y) = x :: g(y)
    })

    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

    def dfs(x: Int, fa: Int): Long = {
      val c = core(nums(x))
      val here = cnt(c)
      cnt(c) += 1

      val sub = g(x).filter(_ != fa).map(dfs(_, x)).sum

      cnt(c) -= 1
      here + sub
    }

    dfs(0, -1)
  }
}
