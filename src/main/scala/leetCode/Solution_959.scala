package leetCode

object Solution_959 {
  def regionsBySlashes(grid: Array[String]): Int = {
    var res = 0
    val N = grid.length
    val dus = new DSU(4 * N * N)
    grid.indices.foreach(i => grid.indices.foreach(j => {
      val root = 4 * (i * N + j)
      val v = grid(i)(j)
      if (v != '\\') {
        dus.union(root + 0, root + 1)
        dus.union(root + 2, root + 3)
      }
      if (v != '/') {
        dus.union(root + 0, root + 2)
        dus.union(root + 1, root + 3)
      }
      if (i + 1 < N) dus.union(root + 3, (root + 4 * N) + 0)
      if (i - 1 >= 0) dus.union(root + 0, (root - 4 * N) + 3)
      if (j + 1 < N) dus.union(root + 2, (root + 4) + 1)
      if (j - 1 >= 0) dus.union(root + 1, (root - 4) + 2)
    }))
    (0 until 4 * N * N).foreach(i => if (dus.find(i) == i) res += 1)
    res
  }
}

private class DSU(_N: Int) {

  private val parent = Array.range(0, _N)

  def find(_x: Int): Int = {
    if (parent(_x) != _x) parent(_x) = find(parent(_x))
    parent(_x)
  }

  def union(_x: Int, _y: Int): Unit = parent(find(_x)) = find(_y)

}
