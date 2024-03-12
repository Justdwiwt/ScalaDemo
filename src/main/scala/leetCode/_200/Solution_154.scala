package leetCode._200

object Solution_154 {
  def findMin(nums: Array[Int]): Int = {

    @annotation.tailrec
    def func(left: Int, right: Int): Int = {
      if (left >= right) nums(left)
      else {
        val mid = left + (right - left) / 2
        if (nums(mid) == nums(right)) func(left, right - 1)
        else if (nums(mid) < nums(right)) func(left, mid)
        else func(mid + 1, right)
      }
    }

    if (nums.head < nums.last) nums.head else func(0, nums.length - 1)
  }
}
