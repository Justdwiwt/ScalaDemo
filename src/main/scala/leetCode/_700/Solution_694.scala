package leetCode._700

object Solution_694 {
  private class DSU(N: Int) {
    private val parent = (0 until N).toArray

    def find(x: Int): Int =
      if (x != parent(x)) find(parent(x)) else x

    def union(x: Int, y: Int): Unit =
      parent(find(x)) = parent(find(y))
  }

  def numDistinctIslands(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0 || grid.head.length == 0) return 0
    val dsu = new DSU(grid.length * grid.head.length)
    val seq = grid.indices.flatMap(i => grid(i).indices.withFilter(grid(i)(_) == 1).map((i, _)))

    def nei(i: Int, j: Int): List[(Int, Int)] =
      List((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1))

    def inBound(p: (Int, Int)): Boolean = p match {
      case (x, y) => x >= 0 && y >= 0 && x < grid.length && y < grid.head.length
    }

    def idx(i: Int, j: Int): Int =
      i * grid.head.length + j

    seq.foreach {
      case (i, j) => nei(i, j).filter(inBound).foreach {
        case (x, y) => if (grid(x)(y) == 1) dsu.union(idx(i, j), idx(x, y))
      }
    }

    seq
      .filter { case (i, j) => grid(i)(j) == 1 }
      .groupBy { case (i, j) => dsu.find(idx(i, j)) }
      .values
      .toList
      .map(l => {
        val sl = l.sorted
        sl.map { case (i, j) => (i - sl.head._1, j - sl.head._2) }
      })
      .distinct
      .length
  }
}
