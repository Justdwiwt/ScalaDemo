package leetCode

import scala.collection.mutable

object Solution_414 {
  def thirdMax(nums: Array[Int]): Int = {
    if (nums.isEmpty) throw new RuntimeException("error")
    val set = new mutable.TreeSet[Int]()
    nums.foreach(i => {
      set.add(i)
      if (set.size > 3) set.remove(set.firstKey)
    })
    if (set.size < 3) set.last else set.firstKey
  }
}
