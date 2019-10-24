package leetCode

import scala.util.Sorting
import scala.util.control.Breaks._

object Solution_15 {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    var res: List[List[Int]] = List[List[Int]]()
    var flag = 0
    Sorting.quickSort(nums)
    if (nums.length < 3 || nums.head > 0 || nums.last < 0)
      return List[List[Int]]()
    breakable {
      nums.indices.foreach(i => {
        val fix = nums(i)
        if (fix > 0) break
        if (i > 0 && fix == nums(i - 1)) flag = 1
        if (flag != 1) {
          var l = i + 1
          var r = nums.length - 1
          while (l < r) {
            if (nums(l) + nums(r) == -fix)
              if (l == i + 1 || r == nums.length - 1) {
                res = res ::: List(List(nums(i), nums(l), nums(r)))
                l += 1
                r -= 1
              } else if (nums(l) == nums(l - 1)) l += 1
              else if (nums(r) == nums(r + 1)) r -= 1
              else {
                res = res ::: List(List(nums(i), nums(l), nums(r)))
                l += 1
                r -= 1
              }
            else if (nums(l) + nums(r) < -fix) l += 1
            else r -= 1
          }
        }
        flag = 0
      })
    }
    res
  }
}
