package leetCode

import scala.collection.mutable

object Solution_2815 {
  def maxSum(nums: Array[Int]): Int = {
    val m = mutable.HashMap.empty[Int, Int]
    nums.indices.foreach(i => {
      val s = nums(i).toString
      val ch = s.toCharArray.sorted
      m += i -> (ch(ch.length - 1) - '0')
    })
    var mx = -1
    nums.indices.foreach(i => (i + 1 until nums.length).foreach(j => if (m.getOrElse(i, 0) == m.getOrElse(j, 0)) mx = mx.max(nums(i) + nums(j))))
    mx
  }
}
