package leetCode._4100

import scala.collection.mutable
import scala.util.Random

object Solution_4033 {
  def validSubarrays(nums: Array[Int], k: Int, queries: Array[Array[Int]]): Array[Boolean] = {
    val rand = new Random()
    val mp = mutable.Map.empty[Int, Long]
    val s = nums.scanLeft(0L)((h, x) => h ^ mp.getOrElseUpdate(x, rand.nextLong()))

    def calcLeft(k: Int): Array[Int] = {
      val cnt = mutable.Map.empty[Int, Int]
      var l = 0

      nums.indices.map { r =>
        val x = nums(r)
        cnt(x) = cnt.getOrElse(x, 0) + 1

        while (cnt.size >= k) {
          val v = nums(l)
          if (cnt(v) == 1) cnt.remove(v)
          else cnt(v) -= 1
          l += 1
        }

        l
      }.toArray
    }

    val l1 = calcLeft(k + 1)
    val l2 = calcLeft(k)

    queries.map { case Array(l, r) => s(r + 1) == s(l) && l1(r) <= l && l < l2(r) }
  }
}
