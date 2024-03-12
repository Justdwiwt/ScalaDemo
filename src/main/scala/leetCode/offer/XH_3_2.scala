package leetCode.offer

import scala.util.control.Breaks._

object XH_3_2 {
  def sortedArray3Sum(nums: Array[Int], target: Int): Array[Int] = {
    var res = Array.emptyIntArray
    if (nums.length < 3) return res
    var j = 0
    var k = 0
    (0 until nums.length - 2).foreach(i => {
      j = i + 1
      breakable {
        if (i > 0 && nums(i) == nums(i - 1)) break()
      }
      k = nums.length - 1
      while (j < k) {
        if (nums(i) + nums(j) + nums(k) < target) {
          j += 1
          while (nums(j) == nums(j - 1) && j < k) j += 1
        } else if (nums(i) + nums(j) + nums(k) > target) {
          k -= 1
          while (nums(k) == nums(k + 1) && j < k) k -= 1
        } else {
          res :+= nums.indexOf(nums(i))
          res :+= nums.indexOf(nums(j))
          res :+= nums.indexOf(nums(k))
          j += 1
          k -= 1
          while (nums(j) == nums(j - 1) && nums(k) == nums(k + 1) && j < k) j += 1
        }
      }
    })
    res
  }
}
