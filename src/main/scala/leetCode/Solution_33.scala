package leetCode

object Solution_33 {
  def search(nums: Array[Int], target: Int): Int = if (nums.isEmpty) -1 else f(nums, target, 0, nums.length - 1)

  @scala.annotation.tailrec
  def f(arr: Array[Int], target: Int, l: Int, r: Int): Int =
    if (l > r) -1
    else {
      val m = (l + r) >>> 1
      if (arr(m) == target) m
      else if (arr(l) <= arr(m) && check(target, arr(l), arr(m))
        || arr(m) <= arr(r) && !check(target, arr(m), arr(r))) f(arr, target, l, m - 1)
      else f(arr, target, m + 1, r)
    }

  def check(target: Int, l: Int, r: Int): Boolean = l <= target && target <= r
}
