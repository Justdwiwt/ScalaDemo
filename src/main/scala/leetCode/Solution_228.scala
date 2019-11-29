package leetCode

import scala.collection.mutable.ListBuffer

object Solution_228 {
  def summaryRanges(nums: Array[Int]): List[String] = {
    var i = 0
    val n = nums.length
    val res = ListBuffer[String]()
    while (i < n) {
      var j = 1
      while (i + j < n && nums(i + j).toLong - nums(i) == j) j += 1
      res.append(if (j <= 1) nums(i).toString else nums(i) + "->" + nums(i + j - 1))
      i += j
    }
    res.toList
  }
}
