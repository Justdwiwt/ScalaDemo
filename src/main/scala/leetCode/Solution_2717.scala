package leetCode

object Solution_2717 {
  def semiOrderedPermutation(nums: Array[Int]): Int = {
    var l = 0
    var r = 0
    val len = nums.length
    nums.indices.foreach(i => {
      if (nums(i) == 1) l = i
      if (nums(i) == len) r = i
    })
    if (r < l) return l + len - 1 - r - 1
    l + len - 1 - r
  }
}
