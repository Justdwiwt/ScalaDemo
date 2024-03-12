package leetCode._500

import scala.collection.mutable

object Solution_446 {
  def numberOfArithmeticSlices(nums: Array[Int]): Int = {
    var res = 0
    val arr = Array.fill(nums.length)(mutable.HashMap.empty[Long, Int])
    nums.indices.foreach(i => {
      val m = mutable.HashMap.empty[Long, Int]
      (0 until i).foreach(j => {
        val diff = nums(i).toLong - nums(j)
        m += diff -> (m.getOrElse(diff, 0) + arr(j).getOrElse(diff, 0) + 1)
        res += arr(j).getOrElse(diff, 0)
      })
      arr(i) = m
    })
    res
  }
}
