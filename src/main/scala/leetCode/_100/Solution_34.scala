package leetCode._100

object Solution_34 {
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val left = binarySearch(nums, target, 0, nums.length - 1, left = true)
    val right = binarySearch(nums, target, 0, nums.length - 1, left = false)
    Array(left, right)
  }

  @scala.annotation.tailrec
  def binarySearch(nums: Array[Int], target: Int, start: Int, end: Int, left: Boolean): Int =
    if (start > end) -1
    else {
      val mid = (end - start) / 2 + start
      if (left) nums(mid) match {
        case n if n == target && !nums.lift(mid - 1).contains(target) => mid
        case n if n < target => binarySearch(nums, target, mid + 1, end, left = true)
        case _ => binarySearch(nums, target, start, mid - 1, left = true)
      } else nums(mid) match {
        case n if n == target && !nums.lift(mid + 1).contains(target) => mid
        case n if n > target => binarySearch(nums, target, start, mid - 1, left = false)
        case _ => binarySearch(nums, target, mid + 1, end, left = false)
      }
    }
}
