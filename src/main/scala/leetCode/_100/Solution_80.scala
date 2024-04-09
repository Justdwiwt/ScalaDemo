package leetCode._100

object Solution_80 {
  def removeDuplicates(nums: Array[Int]): Int = nums.foldLeft(0) { case (idx, num) =>
    if (idx < 2 || num != nums(idx - 2)) {
      nums(idx) = num
      idx + 1
    } else idx
  }
}
