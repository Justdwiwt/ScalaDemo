package leetCode._2400

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2392 {
  private def sort(k: Int, conditions: Array[Array[Int]]): Array[Int] = {
    val inDegrees = mutable.Map[Int, Int]().withDefaultValue(0)
    val adjacency = mutable.Map[Int, ArrayBuffer[Int]]().withDefaultValue(ArrayBuffer.empty)

    conditions
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(a, b) =>
        inDegrees(b) += 1
        adjacency.getOrElseUpdate(a, ArrayBuffer.empty[Int]).append(b)
      }

    (1 to k).foreach(inDegrees.getOrElseUpdate(_, 0))

    val ans = ArrayBuffer.empty[Int]

    while (ans.length != k) {
      val roots = inDegrees.filter(_._2 == 0).keys.toList
      if (roots.isEmpty) return Array.empty
      roots.foreach(inDegrees.remove)
      ans.appendAll(roots)
      roots.flatMap(adjacency).foreach(inDegrees(_) -= 1)
    }

    ans.toArray
  }

  def buildMatrix(k: Int, rowConditions: Array[Array[Int]], colConditions: Array[Array[Int]]): Array[Array[Int]] = {
    val rowIndex = sort(k, rowConditions)
    val colIndex = sort(k, colConditions)
    if (rowIndex.isEmpty || colIndex.isEmpty) return Array.empty
    val matrix = Array.ofDim[Int](k, k)
    (1 to k).foreach(i => matrix(rowIndex.indexOf(i))(colIndex.indexOf(i)) = i)
    matrix
  }
}
