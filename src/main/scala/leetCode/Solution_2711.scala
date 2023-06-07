package leetCode

import scala.collection.mutable

object Solution_2711 {
  def differenceOfDistinctValues(grid: Array[Array[Int]]): Array[Array[Int]] = {
    val m = grid.length
    val n = grid.head.length
    val res = Array.fill(m, n)(0)
    grid.indices.foreach(i => {
      grid.head.indices.foreach(j => {
        val ts = mutable.HashSet.empty[Int]
        val bs = mutable.HashSet.empty[Int]
        var t = i - 1
        var l = j - 1
        var b = i + 1
        var r = j + 1
        while (t >= 0 && l >= 0) {
          ts += grid(t)(l)
          t -= 1
          l -= 1
        }
        while (b < m && r < n) {
          bs += grid(b)(r)
          b += 1
          r += 1
        }
        res(i)(j) = (ts.size - bs.size).abs
      })
    })
    res
  }
}
