package leetCode

class Solution_268 {
  def missingNumber(nums: Array[Int]): Int = {
    var res = nums.length
    nums.indices.foreach(i => res = res ^ nums(i) ^ i)
    res
  }
}
