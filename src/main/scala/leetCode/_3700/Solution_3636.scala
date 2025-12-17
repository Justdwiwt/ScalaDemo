package leetCode._3700

import scala.math._

object Solution_3636 {
  def subarrayMajority(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = nums.length
    val m = queries.length

    val values = nums.distinct.sorted
    val idx = nums.map(java.util.Arrays.binarySearch(values, _))

    var cnt = Array.fill(values.length)(0)
    var maxCnt = 0
    var minVal = 0

    def add(i: Int): Unit = {
      val v = idx(i)
      cnt(v) += 1
      val c = cnt(v)
      val x = nums(i)
      if (c > maxCnt || (c == maxCnt && x < minVal)) {
        maxCnt = c
        minVal = x
      }
    }

    val ans = Array.fill(m)(-1)
    val blockSize = ceil(n.toDouble / sqrt(m * 2)).toInt

    val bigQs =
      queries.zipWithIndex.flatMap { case (Array(l, r0, t), id) =>
        val r = r0 + 1
        if (r - l > blockSize) Some((l / blockSize, l, r, t, id))
        else {
          (l until r).foreach(add)
          if (maxCnt >= t) ans(id) = minVal
          (l until r).foreach(i => cnt(idx(i)) -= 1)
          maxCnt = 0
          None
        }
      }.sortBy(q => (q._1, q._3))

    var r = 0
    var lastBid = -1

    bigQs.foreach { case (bid, l, qr, t, id) =>
      val l0 = (bid + 1) * blockSize
      if (bid != lastBid) {
        r = l0
        cnt = Array.fill(values.length)(0)
        maxCnt = 0
        lastBid = bid
      }

      while (r < qr) {
        add(r)
        r += 1
      }

      val savedMax = maxCnt
      val savedMin = minVal

      (l until l0).foreach(add)
      if (maxCnt >= t) ans(id) = minVal

      maxCnt = savedMax
      minVal = savedMin
      (l until l0).foreach(i => cnt(idx(i)) -= 1)
    }

    ans
  }
}
