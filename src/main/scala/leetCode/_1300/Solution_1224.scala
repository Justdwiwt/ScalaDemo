package leetCode._1300

import scala.collection.mutable

object Solution_1224 {
  def maxEqualFreq(nums: Array[Int]): Int = {
    val cnt = mutable.HashMap.empty[Int, Int]
    val freq = mutable.HashMap.empty[Int, Int]
    nums.indices.foldLeft(0, 0)((b, a) => {
      cnt.put(nums(a), cnt.getOrElseUpdate(nums(a), 0) + 1)
      freq.put(cnt(nums(a)) - 1, freq.getOrElseUpdate(cnt(nums(a)) - 1, 0) - 1)
      freq.put(cnt(nums(a)), freq.getOrElseUpdate(cnt(nums(a)), 0) + 1)
      val maxF = b._1.max(cnt(nums(a)))
      (maxF, if (maxF * freq(maxF) == a || (maxF - 1) * (freq(maxF - 1) + 1) == a || maxF == 1) a + 1 else b._2)
    })._2
  }
}
