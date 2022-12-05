package leetCode

object Solution_361 {
  //  def maxKilledEnemies(grid: Array[Array[Char]]): Int = {
  //    if (grid == null || grid.isEmpty || grid.head.isEmpty) return 0
  //    var res = 0
  //    grid.indices.foreach(i => grid.head.indices.foreach(j => if (grid(i)(j) == '0') res = res.max(cnt(grid, i, j))))
  //    res
  //  }
  //
  //  def cnt(graph: Array[Array[Char]], i: Int, j: Int): Int = {
  //    var res = 0
  //    (j - 1 to 0 by -1).withFilter(c => graph(i)(c) != 'W').foreach(c => if (graph(i)(c) == 'E') res += 1)
  //    (j + 1 until graph.head.length).withFilter(c => graph(i)(c) != 'W').foreach(c => if (graph(i)(c) == 'E') res += 1)
  //    (i - 1 to 0 by -1).withFilter(r => graph(r)(j) != 'W').foreach(r => if (graph(r)(j) == 'E') res += 1)
  //    (i + 1 until graph.length).withFilter(r => graph(r)(j) != 'W').foreach(r => if (graph(r)(j) == 'E') res += 1)
  //    res
  //  }
}
