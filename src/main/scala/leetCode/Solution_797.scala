package leetCode

import scala.collection.mutable.ListBuffer

object Solution_797 {
  def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
    var res = List.empty[List[Int]]
    val path = ListBuffer.empty[Int]
    findPath(graph, 0, path)

    def findPath(graph: Array[Array[Int]], v: Int, path: ListBuffer[Int]): Unit = {
      path.append(v)
      if (v == graph.length - 1) res :+= path.toList
      graph(v).foreach(e => findPath(graph, e, path))
      path.remove(path.length - 1)
    }

    res
  }
}
