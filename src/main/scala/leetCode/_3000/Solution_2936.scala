package leetCode._3000

object Solution_2936 {
  abstract class BigArray(elements: Array[Int]) {
    def at(x: Long): Int

    def size(): Long
  }

  def countBlocks(nums: BigArray): Int =
    countBlocks(nums, 0, nums.size())

  private def countBlocks(nums: BigArray, start: Long, end: Long): Int =
    if (nums.at(start) == nums.at(end - 1)) 1
    else {
      val mid = (start + end) >>> 1
      val cnt = countBlocks(nums, start, mid) + countBlocks(nums, mid, end)
      if (nums.at(mid - 1) == nums.at(mid)) cnt - 1 else cnt
    }
}
