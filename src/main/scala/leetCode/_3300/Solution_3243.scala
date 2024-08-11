package leetCode._3300

import scala.collection.mutable.ArrayBuffer

object Solution_3243 {
  def shortestDistanceAfterQueries(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    val from = Array.fill(n)(ArrayBuffer.empty[Int])
    val arr = Array.tabulate(n)(i => if (i == 0) 0 else i)

    queries.indices.map(q => {
      val Array(l, r) = queries(q)
      from(r).append(l)
      if (arr(l) + 1 < arr(r)) {
        arr(r) = arr(l) + 1
        (r + 1 until n).foreach(i => {
          arr(i) = arr(i).min(arr(i - 1) + 1)
          from(i).foreach(j => arr(i) = arr(i).min(arr(j) + 1))
        })
      }
      arr(n - 1)
    }).toArray
  }
}
