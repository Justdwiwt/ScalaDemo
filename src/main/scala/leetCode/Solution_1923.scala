package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_1923 {
  def longestCommonSubpath(n: Int, paths: Array[Array[Int]]): Int = {
    val mn = paths.map(_.length).min
    var left = 0
    var right = mn
    val base = 100001.toLong
    val M = math.pow(10, 12).toLong + 9
    while (left <= right) {
      val mid = left + (right - left) / 2
      var common = mutable.HashSet[Long]()
      breakable {
        paths.indices.foreach(i => {
          var hash = 0.toLong
          var d = 1.toLong
          val st = mutable.HashSet[Long]()
          paths(i).indices.foreach(j => {
            hash = (hash * base + paths(i)(j)) % M
            if (j >= mid) hash = (hash + M - paths(i)(j - mid) * d % M) % M
            else d = d * base % M
            if (j >= mid - 1 && (i == 0 || common.contains(hash))) st += hash
          })
          common = st
        })
        if (common.isEmpty) break
      }
      if (common.isEmpty) right = mid - 1
      else left = mid + 1
    }
    right
  }
}
