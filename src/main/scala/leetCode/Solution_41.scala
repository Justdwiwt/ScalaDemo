package leetCode

object Solution_41 {
  def firstMissingPositive(nums: Array[Int]): Int = {
    nums.indices.foreach(i => {
      while (nums(i) > 0 && nums(i) <= nums.length && nums(nums(i) - 1) != nums(i))
        swap(nums, nums(i) - 1, i)
    })
    nums.indices.foreach(i => if (nums(i) != i + 1) return i + 1)
    nums.length + 1
  }

  def swap(nums: Array[Int], index1: Int, index2: Int): Unit = {
    if (index1 == index2) return
    val tmp = nums(index1)
    nums(index1) = nums(index2)
    nums(index2) = tmp
  }
}
