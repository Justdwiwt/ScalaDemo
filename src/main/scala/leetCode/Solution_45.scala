package leetCode

object Solution_45 {
  def jump(nums: Array[Int]): Int =
    f(nums, nums.length - 1, 0, 0, 0, 0)

  @scala.annotation.tailrec
  def f(nums: Array[Int], target: Int, i: Int, steps: Int, cur: Int, mx: Int): Int = {
    if (i == target) return steps
    val nextReach = cur.max(i + nums(i))
    if (nextReach >= target) return steps + 1
    if (i == mx) f(nums, target, i + 1, steps + 1, nextReach, nextReach)
    else f(nums, target, i + 1, steps, nextReach, mx)
  }
}
