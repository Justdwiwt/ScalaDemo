package leetCode._3700

import scala.collection.mutable

object Solution_3655 {
  private val M = 1000000007L

  def xorAfterQueries(nums: Array[Int], queries: Array[Array[Int]]): Int = {
    val n = nums.length
    val m = queries.length
    val B = math.sqrt(m).toInt max 1

    val big = mutable.ArrayBuffer[Array[Int]]()
    val small = mutable.ArrayBuffer[Array[Int]]()

    queries.foreach(q => if (q(2) >= B) big += q else small += q)

    big
      .withFilter { case Array(l, r, k, v) => true; case _ => false }
      .foreach { case Array(l, r, k, v) =>
        var i = l
        val vv = v.toLong
        val rr = r.min(n - 1)
        while (i <= rr) {
          nums(i) = ((nums(i).toLong * vv) % M).toInt
          i += k
        }
      }

    (1 until B).foreach(k => {
      val buckets = Array.fill(k)(mutable.ArrayBuffer[(Int, Int, Long)]())

      small
        .withFilter { case Array(l, r, kk, v) => true; case _ => false }
        .withFilter { case Array(l, r, kk, v) => kk == k }
        .foreach { case Array(l, r, kk, v) =>
          if (l < n) {
            val rr = r.min(n - 1)
            buckets(l % k) += ((l, rr, v.toLong))
          }
        }

      (0 until k).foreach(start => {
        val bucket = buckets(start)
        if (bucket.nonEmpty) {
          val mlen = (n - 1 - start) / k + 1
          val diff = Array.fill[Long](mlen + 2)(1L)

          bucket.foreach { case (l, r, v) =>
            val lp = (l - start) / k
            val rp = (r - start) / k
            diff(lp) = diff(lp) * v % M
            diff(rp + 1) = diff(rp + 1) * powInv(v) % M
          }

          var cur = 1L
          var i = 0
          while (i < mlen) {
            cur = cur * diff(i) % M
            val idx = start + i * k
            nums(idx) = ((nums(idx).toLong * cur) % M).toInt
            i += 1
          }
        }
      })
    })

    nums.foldLeft(0)(_ ^ _)
  }

  private def powInv(v: Long): Long =
    pow(v, M - 2)

  private def pow(a: Long, b: Long): Long = {
    var x = a % M
    var e = b
    var res = 1L
    while (e > 0) {
      if ((e & 1) == 1) res = res * x % M
      x = x * x % M
      e >>= 1
    }
    res
  }
}
