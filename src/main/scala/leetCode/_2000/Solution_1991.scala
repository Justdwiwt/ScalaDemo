package leetCode._2000

object Solution_1991 {
  def findMiddleIndex(nums: Array[Int]): Int =
    f(nums, nums.sum, 0, 0)

  @scala.annotation.tailrec
  def f(nums: Array[Int], totalSum: Int, leftSum: Int, curIdx: Int): Int =
    if (curIdx < nums.length)
      if (leftSum * 2 == (totalSum - nums(curIdx))) curIdx
      else f(nums, totalSum, leftSum + nums(curIdx), curIdx + 1)
    else -1
}
