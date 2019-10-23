package leetCode

import scala.collection.mutable.ListBuffer

class Solution_448 {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    var res = new ListBuffer[Int]
    nums.indices.foreach(i => {
      val m = math.abs(nums(i)) - 1
      nums(m) = if (nums(m) > 0) -nums(m) else nums(m)
    })
    nums.indices.foreach(i => if (nums(i) > 0) res += (i + 1))
    res.toList
  }
}
