package leetCode._3000

import scala.collection.mutable

object Solution_2975 {
  def maximizeSquareArea(m: Int, n: Int, hFences: Array[Int], vFences: Array[Int]): Int = {
    val M = (1e9 + 7).toInt
    val s1 = mutable.HashSet.empty[Int]
    val s2 = mutable.HashSet.empty[Int]
    s1 += (m - 1)
    s2 += (n - 1)
    hFences.foreach(a => {
      s1 += (a - 1)
      s1 += (m - a)
      hFences.foreach(b => s1 += (a - b).abs)
    })
    vFences.foreach(a => {
      s2 += (a - 1)
      s2 += (n - a)
      vFences.foreach(b => s2 += (a - b).abs)
    })
    var res = 0L
    s1.foreach(a => if (a > res && s2.contains(a)) res = a)
    if (res == 0) -1 else (res * res % M).toInt
  }
}
