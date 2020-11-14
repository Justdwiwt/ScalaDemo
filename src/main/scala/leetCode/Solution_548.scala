package leetCode

import scala.collection.mutable

object Solution_548 {
  def splitArray(nums: Array[Int]): Boolean = {
    val sums = Array.fill(nums.length)(0)
    sums(0) = nums.head
    sums.indices.drop(1).foreach(i => sums(i) = nums(i) + sums(i - 1))
    (3 until nums.length - 2).foreach(j => {
      var st = mutable.HashSet.empty[Int]
      (1 until j - 1).foreach(i => if (sums(i - 1) == sums(j - 1) - sums(i)) st += sums(i - 1))
      (nums.length - 2 until j + 1 by -1).foreach(k => if (sums(nums.length - 1) - sums(k) == sums(k - 1) - sums(j) && st.contains(sums(nums.length - 1) - sums(k))) return true)
    })
    false
  }
}
