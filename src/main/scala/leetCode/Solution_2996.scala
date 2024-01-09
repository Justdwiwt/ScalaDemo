package leetCode

import scala.collection.mutable

object Solution_2996 {
  def missingInteger(nums: Array[Int]): Int = {
    val st = mutable.HashSet.empty[Int]
    nums.foreach(a => st += a)
    var res = nums.head
    val n = nums.length
    var i = 1
    while (i < n && nums(i) == nums(i - 1) + 1) {
      res += nums(i)
      i += 1
    }
    while (st.contains(res)) res += 1
    res
  }
}
