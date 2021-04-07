package leetCode

object Solution_81 {
  def search(nums: Array[Int], target: Int): Boolean = {
    nums.indices.foreach(i =>
      if (nums(i) == target) return true
      else if (i < nums.length - 1)
        if ((nums(i) < target) & (nums(i) > nums(i + 1))) return false)
    false
  }
}
