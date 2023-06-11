package leetCode

import scala.collection.mutable

object Solution_2718 {
  def matrixSumQueries(n: Int, queries: Array[Array[Int]]): Long = {
    var res = 0L
    var row = n
    var col = n
    val stRow = mutable.HashSet.empty[Int]
    val stCol = mutable.HashSet.empty[Int]
    queries.indices.reverse.foreach(i => {
      if (!stRow.contains(queries(i)(1)) && queries(i).head == 0) {
        res += row * queries(i)(2)
        col -= 1
        stRow += queries(i)(1)
      }
      if (!stCol.contains(queries(i)(1)) && queries(i).head == 1) {
        res += col * queries(i)(2)
        row -= 1
        stCol += queries(i)(1)
      }
    })
    res
  }
}
