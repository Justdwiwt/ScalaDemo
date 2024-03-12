package leetCode._2900

import scala.collection.mutable

object Solution_2870 {
  def minOperations(nums: Array[Int]): Int = {
    val m = mutable.HashMap.empty[Int, Int]
    nums.foreach(n => m += n -> (m.getOrElse(n, 0) + 1))
    var res = 0
    m.values.foreach(v => {
      if (v == 1) return -1
      res += v / 3
      if (v % 3 != 0) res += 1
    })
    res
  }
}
