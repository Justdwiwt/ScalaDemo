package leetCode

object Solution_1557 {
  def findSmallestSetOfVertices(n: Int, edges: List[List[Int]]): List[Int] = {
    (0 until n).diff(edges.map(_.last)).toList
  }
}
