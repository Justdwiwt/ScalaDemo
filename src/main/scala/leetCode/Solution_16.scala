package leetCode

import scala.math.abs
import scala.util.Sorting.quickSort

object Solution_16 {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    var res: Long = Int.MaxValue
    quickSort(nums)
    for (i <- nums.indices) {
      var pStart = i + 1
      var pEnd = nums.length - 1
      while (pStart < pEnd) {
        val sum = nums(i) + nums(pStart) + nums(pEnd)
        if (sum == target) {
          pStart += 1
          pEnd -= 1
        }
        else if (sum > target) pEnd -= 1
        else pStart += 1
        if (abs(sum - target) < abs(res - target)) res = sum
      }
    }
    res.toInt
  }
}
