package leetCode

import scala.collection.mutable

object Offer_03 {
  def findRepeatNumber(nums: Array[Int]): Int = {
    val s = new mutable.HashSet[Int]()
    nums.foreach(i => if (!s.add(i)) return i)
    -1
  }
}
