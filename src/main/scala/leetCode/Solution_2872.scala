package leetCode

object Solution_2872 {
  def maxKDivisibleComponents(n: Int, edges: Array[Array[Int]], values: Array[Int], k: Int): Int = {
    val arr = Array.fill(n)(List.empty[Int])
    edges.foreach(edge => {
      val x = edge.head
      val y = edge(1)
      arr(x) = y :: arr(x)
      arr(y) = x :: arr(y)
    })

    var res = 0L

    def f(x: Int, fa: Int): Long = {
      var s = values(x).toLong
      arr(x).foreach(y => if (y != fa) s += f(y, x))
      if (s % k == 0) res += 1
      s
    }

    f(0, -1)
    res.toInt
  }
}
