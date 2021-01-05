package leetCode

object Solution_55 {
  def canJump(nums: Array[Int]): Boolean = 0 == (nums.length - 1 to(0, -1))./:(nums.length - 1)((l, r) => if (nums(r) + r >= l) r else l)
}
