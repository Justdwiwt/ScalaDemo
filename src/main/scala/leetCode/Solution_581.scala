package leetCode

object Solution_581 {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    var start = -1
    var end = -2
    var mn = nums(nums.length - 1)
    var mx = nums(0)
    (1 until nums.length).foreach(i => {
      mx = mx.max(nums(i))
      mn = mn.min(nums(nums.length - 1 - i))
      if (mx > nums(i)) end = i
      if (mn < nums(nums.length - 1 - i)) start = nums.length - 1 - i
    })
    end - start + 1
  }
}
