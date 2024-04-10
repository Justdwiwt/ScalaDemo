package leetCode._3100

import scala.collection.mutable.ArrayBuffer

object Solution_3086 {
  def minimumMoves(nums: Array[Int], k: Int, maxChanges: Int): Long = {
    var cnt = 0
    var cur = 0
    val ab = ArrayBuffer.empty[Int]

    nums.indices.foreach(i => if (nums(i) == 1) {
      cur += 1
      ab += i
    } else {
      cnt = cnt.max(cur)
      cur = 0
    })

    cnt = cnt.max(cur)
    if (cnt >= 3) cnt = 3
    cnt = cnt.min(k)

    if (cnt + maxChanges >= k) return 0.max(cnt - 1) + 2 * (k - cnt)

    val s = Array.fill(ab.length + 1)(0L)
    (1 to ab.length).foreach(i => s(i) = s(i - 1) + ab(i - 1))

    val size = k - maxChanges
    var res = Long.MaxValue

    (size - 1 until ab.size).foreach(right => {
      val left = right - size + 1
      val mid = (left + right) / 2
      val curSum = (mid - left) * ab(mid) - (s(mid) - s(left)) + s(right + 1) - s(mid + 1) - (right - mid) * ab(mid)
      res = res.min(curSum)
    })

    res + maxChanges * 2
  }
}
