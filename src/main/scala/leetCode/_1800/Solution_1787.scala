package leetCode._1800

import scala.collection.mutable

object Solution_1787 {
  def minChanges(nums: Array[Int], k: Int): Int = {
    if (k == 1) return nums.count(_ != 0)

    @scala.annotation.tailrec
    def findN(m: Int, n: Int = 1): Int =
      if (n <= m) findN(m, n * 2) else n

    val n = findN(nums.max)
    val g = nums.zipWithIndex

    def freq(r: Int): mutable.Map[Int, Int] = g./:(mutable.Map.empty[Int, Int])((m, p) => {
      if (p._2 % k == r) m(p._1) = m.getOrElse(p._1, 0) + 1
      m
    })

    @scala.annotation.tailrec
    def check(pa: Array[Int] = Array.empty[Int], minPre: Int = n, r: Int = 0): Int = {
      val fr = freq(r)
      val nr = fr.values.sum
      if (r == 0) check((0 until n).map(i => nr - fr.getOrElse(i, 0)).toArray, nr - fr.values.max, r + 1)
      else {
        val na = Array.fill[Int](n)(minPre + nr)
        (0 until n).foreach(i => fr
          .map({ case (d, c) => val j = i ^ d; ((d, c), j) })
          .foreach({ case ((_, c), j) => na(j) = na(j).min(pa(i) + nr - c) }))
        if (r == k - 1) na(0) else check(na, na.min, r + 1)
      }
    }

    check()
  }
}
