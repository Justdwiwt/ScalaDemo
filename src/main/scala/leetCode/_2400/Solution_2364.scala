package leetCode._2400

import scala.collection.mutable

object Solution_2364 {
  def countBadPairs(nums: Array[Int]): Long = {
    val n = nums.length.toLong
    var cnt = n * (n - 1) / 2
    val m = mutable.HashMap.empty[Int, Int]
    nums.indices.foreach(i => {
      val d = nums(i) - i
      var t = m.getOrElse(d, 0)
      cnt -= t
      m += d -> (t + 1)
    })
    cnt
  }
}
