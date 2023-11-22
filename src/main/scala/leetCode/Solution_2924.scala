package leetCode

object Solution_2924 {
  def findChampion(n: Int, edges: Array[Array[Int]]): Int = {
    val acc = (0 until n).toSet.diff(edges.map(_(1)).toSet)
    if (acc.size == 1) acc.head else -1
  }
}
