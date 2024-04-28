package leetCode._1800

import scala.util.Sorting

object Solution_1724 {
  class DistanceLimitedPathsExist(n: Int, edgeList: Array[Array[Int]]) {
    var dsu: Array[Array[Int]] = Array.fill(n)(Array(0, 0))

    (0 until n).foreach(i => {
      dsu(i)(0) = i
      dsu(i)(1) = 0
    })

    Sorting.quickSort(edgeList)(Ordering.by(_(2)))

    edgeList.foreach(edge => {
      var a = edge(0)
      var b = edge(1)
      while (dsu(a)(0) != a) {
        a = dsu(a)(0)
      }
      while (dsu(b)(0) != b) {
        b = dsu(b)(0)
      }
      if (a != b) {
        dsu(a)(0) = b
        dsu(a)(1) = edge(2)
      }
    })

    def query(p: Int, q: Int, limit: Int): Boolean = {
      var a = p
      var b = q
      while (dsu(a)(0) != a && dsu(a)(1) < limit) a = dsu(a)(0)
      while (dsu(b)(0) != b && dsu(b)(1) < limit) b = dsu(b)(0)
      a == b
    }
  }
}
