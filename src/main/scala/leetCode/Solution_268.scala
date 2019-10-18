package leetCode

class Solution_268 {
  def missingNumber(nums: Array[Int]): Int = {
    var res = nums.length
    for (i <- nums.indices) res = res ^ nums(i) ^ i
    res
  }
}
