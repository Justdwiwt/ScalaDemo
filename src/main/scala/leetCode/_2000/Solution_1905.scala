package leetCode._2000

object Solution_1905 {
  def countSubIslands(g1: Array[Array[Int]], g2: Array[Array[Int]]): Int = {
    def f(i: Int, j: Int): Boolean = {
      if (i < 0 || i >= g1.length || j < 0 || j >= g1.head.length || g2(i)(j) <= 0) return true
      if (g2(i)(j) == 1 && g1(i)(j) != 1) return false
      g2(i)(j) = -1
      Seq((0, 1), (0, -1), (1, 0), (-1, 0)).map(d => f(i + d._1, j + d._2)).reduce(_ & _)
    }

    g1
      .indices
      .map(i => g1.head.indices.count(j => g2(i)(j) == 1 && f(i, j)))
      .sum
  }
}
