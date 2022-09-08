package leetCode

import scala.collection.mutable

object Solution_2395 {
  def findSubarrays(nums: Array[Int]): Boolean = {
    val st = mutable.HashSet.empty[Int]
    nums.indices.drop(1).foreach(i => if (!st.add(nums(i - 1) + nums(i))) return true)
    false
  }
}
