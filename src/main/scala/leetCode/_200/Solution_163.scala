package leetCode._200

import scala.collection.mutable.ListBuffer

object Solution_163 {
  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    var res = ListBuffer.empty[String]
    var pre = lower.toLong - 1L
    nums.indices.foreach(i => {
      if (nums(i) - pre == 2) res += (pre + 1).toString
      else if (nums(i) - pre > 2) res += ((pre + 1) + "->" + (nums(i) - 1))
      pre = nums(i)
    })
    if (upper - pre == 1) res += (pre + 1).toString
    else if (upper - pre > 1) res += ((pre + 1) + "->" + upper)
    res.toList
  }
}
