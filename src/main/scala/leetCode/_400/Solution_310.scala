package leetCode._400

import scala.collection.mutable

object Solution_310 {
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
    if (n < 2) return (0 until n).toList
    var edgeList = mutable.Map[Int, Set[Int]]().withDefaultValue(Set())
    edges.foreach(e => {
      edgeList(e(0)) += e(1)
      edgeList(e(1)) += e(0)
    })
    while (edgeList.size > 2) {
      val (leaves, nonLeaves) = edgeList.partition({ case (_, v) => v.size == 1 })
      edgeList = nonLeaves.map({ case (k, v) => (k, v.filterNot(leaves.contains)) })
    }
    edgeList.keys.toList
  }
}
