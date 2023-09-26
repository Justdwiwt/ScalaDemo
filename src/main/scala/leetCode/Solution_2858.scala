package leetCode

object Solution_2858 {
  var g: Array[List[Int]] = _
  var t: Array[Set[Int]] = _
  var n: Int = _
  var res: Array[Int] = _
  var cnt: Array[Int] = _

  def minEdgeReversals(n: Int, edges: Array[Array[Int]]): Array[Int] = {
    this.n = n
    res = Array.fill(n)(0)
    cnt = Array.fill(n)(0)
    g = Array.fill(n)(Nil)
    t = Array.fill(n)(Set.empty[Int])

    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x) = y :: g(x)
      g(y) = x :: g(y)
      t(x) += y
    })

    f(0, -1)
    res(0) = cnt.head
    g(0, -1)

    res
  }

  private def f(x: Int, fa: Int): Unit = {
    g(x).foreach(y => if (y != fa) {
      f(y, x)
      if (!t(x).contains(y)) cnt(x) += 1
      cnt(x) += cnt(y)
    })
  }

  private def g(x: Int, fa: Int): Unit = {
    g(x).foreach(y => if (y != fa) {
      res(y) = res(x)
      if (t(x).contains(y) && !t(y).contains(x)) res(y) += 1
      else if (!t(x).contains(y) && t(y).contains(x)) res(y) -= 1
      g(y, x)
    })
  }
}
