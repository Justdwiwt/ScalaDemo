package leetCode

object Solution_1559 {
  def containsCycle(grid: Array[Array[Char]]): Boolean = {
    val arr = Array.fill(grid.length * grid.head.length)(0)

    def find(x: Int): Int = {
      if (x != arr(x))
        arr(x) = find(arr(x))
      arr(x)
    }

    arr.indices.foreach(i => arr(i) = i)
    grid.indices.foreach(i => grid.head.indices.foreach(j => {
      if (j != grid.head.length - 1 && grid(i)(j) == grid(i)(j + 1)) {
        val fx = find(i * grid.head.length + j)
        val fy = find(i * grid.head.length + j + 1)
        if (fx == fy) return true
        else arr(fx) = fy
      }
      if (i != grid.length - 1 && grid(i)(j) == grid(i + 1)(j)) {
        val fx = find(i * grid.head.length + j)
        val fy = find((i + 1) * grid.head.length + j)
        if (fx == fy) return true
        else arr(fx) = fy
      }
    }))
    false
  }
}
