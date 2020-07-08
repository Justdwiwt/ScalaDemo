package leetCode

import scala.collection.mutable

object Code_17_10 {
  def majorityElement(nums: Array[Int]): Int = {
    val m = new mutable.HashMap[Int, Int]()
    nums.indices.foreach(i => {
      m.put(nums(i), m.getOrElse(nums(i), 0) + 1)
      if (m(nums(i)) > nums.length / 2) return nums(i)
    })
    -1
  }
}
