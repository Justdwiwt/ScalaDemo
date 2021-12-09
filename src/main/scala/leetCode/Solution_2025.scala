package leetCode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2025 {
  def waysToPartition(nums: Array[Int], k: Int): Int = {
    val m = mutable.HashMap.empty[Long, ArrayBuffer[Int]]
    val arr = Array.ofDim[Long](nums.length)

    arr(0) = nums.head.toLong
    nums.indices.drop(1).foreach(i => arr(i) = arr(i - 1) + nums(i).toLong)

    val f = (s: Int, e: Int) => if (s == 0) arr(e) else arr(e) - arr(s - 1)

    var res = 0

    nums.indices.drop(1).foreach(i => {
      val diff = arr(i - 1) - f(i, nums.length - 1)
      if (diff == 0L) res += 1
      if (!m.contains(diff)) m += (diff -> ArrayBuffer.empty[Int])
      m(diff) += i
    })

    def g(d: Long, idx: Int): Int = {
      if (!m.contains(d) || d == 0L) return 0
      val arr = m(d)
      var s = 0
      var e = arr.length - 1
      if (arr(e) < idx) return 0
      var r = 0
      while (s <= e) {
        val mid = (s + e) >> 1
        if (arr(mid) > idx) {
          r = r.max(arr.length - mid)
          e = mid - 1
        }
        else s = mid + 1
      }
      r
    }

    def h(d: Long, idx: Int): Int = {
      if (!m.contains(d) || d == 0L) return 0
      val arr = m(d)
      var s = 0
      var e = arr.length - 1
      if (arr(s) > idx) return 0
      var r = 0
      while (s <= e) {
        val mid = (s + e) >> 1
        if (arr(mid) <= idx) {
          r = r.max(mid + 1)
          s = mid + 1
        }
        else e = mid - 1
      }
      r
    }

    if (m.contains(nums.head - k) && nums.head != k)
      res = res.max(m(nums.head - k).size)

    if (m.contains(k - nums(nums.length - 1)) && nums(nums.length - 1) != k)
      res = res.max(m(k - nums(nums.length - 1)).size)

    nums.indices.drop(1).foreach(i => {
      val diff = (k - nums(i)).toLong
      res = res.max(g(-diff, i) + h(diff, i))
    })

    res
  }
}
