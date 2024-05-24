package leetCode._3000

import scala.collection.mutable.ListBuffer

// fixme: case 612/614 stack overflow
object Solution_2973 {
  def placedCoins(edges: Array[Array[Int]], cost: Array[Int]): Array[Long] = {
    val n = cost.length
    val g = Array.fill[ListBuffer[Int]](n)(ListBuffer.empty)
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x) += y
      g(y) += x
    })

    val res = Array.fill(n)(0L)
    dfs(0, -1, cost, g, res)
    res
  }

  private def dfs(x: Int, fa: Int, cost: Array[Int], g: Array[ListBuffer[Int]], res: Array[Long]): List[Int] = {
    var a = ListBuffer(cost(x))
    g(x).foreach(y => if (y != fa) a ++= dfs(y, x, cost, g, res))
    a = a.sorted
    val m = a.length
    if (m < 3) res(x) = 1
    else res(x) = List(a(m - 3).toLong * a(m - 2) * a(m - 1), a.head.toLong * a(1) * a(m - 1), 0).max
    if (m > 5) a = ListBuffer(a.head, a(1), a(m - 3), a(m - 2), a(m - 1))
    a.toList
  }
}
