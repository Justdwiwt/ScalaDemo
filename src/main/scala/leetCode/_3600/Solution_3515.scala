package leetCode._3600

object Solution_3515 {
  private class FenwickTree(n: Int) {
    private val tree = new Array[Int](n + 1)

    def update(i: Int, value: Int): Unit = {
      var idx = i
      while (idx < tree.length) {
        tree(idx) += value
        idx += idx & -idx
      }
    }

    def prefixSum(i: Int): Int = {
      var result = 0
      var idx = i
      while (idx > 0) {
        result += tree(idx)
        idx -= idx & -idx
      }
      result
    }
  }

  def treeQueries(n: Int, edges: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val g = Array.fill(n + 1)(List.empty[Int])

    edges.foreach {
      case Array(x, y, _) =>
        g(x) = y :: g(x)
        g(y) = x :: g(y)
    }

    val in = Array.fill(n + 1)(0)
    val out = Array.fill(n + 1)(0)
    var clock = 0

    def dfs(x: Int, parent: Int): Unit = {
      in(x) = {
        clock += 1
        clock
      }
      g(x).foreach(y => if (y != parent) dfs(y, x))
      out(x) = clock
    }

    dfs(1, -1)

    val weight = Array.fill(n + 1)(0)
    val fenwickTree = new FenwickTree(n)

    edges.foreach {
      case Array(x, y, w) =>
        var (xTemp, yTemp) = (x, y)
        if (in(xTemp) > in(yTemp)) {
          val temp = xTemp
          xTemp = yTemp
          yTemp = temp
        }
        weight(yTemp) = w
        fenwickTree.update(in(yTemp), w)
        fenwickTree.update(out(yTemp) + 1, -w)
    }

    def updateEdge(x: Int, y: Int, w: Int): Unit = {
      var (xTemp, yTemp) = (x, y)
      if (in(xTemp) > in(yTemp)) {
        val temp = xTemp
        xTemp = yTemp
        yTemp = temp
      }

      val diff = w - weight(yTemp)
      weight(yTemp) = w

      fenwickTree.update(in(yTemp), diff)
      fenwickTree.update(out(yTemp) + 1, -diff)
    }

    queries.flatMap {
      case Array(1, x, y, w) =>
        updateEdge(x, y, w)
        None
      case Array(2, x) => Some(fenwickTree.prefixSum(in(x)))
    }
  }
}
