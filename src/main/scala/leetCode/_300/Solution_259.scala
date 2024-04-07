package leetCode._300

object Solution_259 {
  def threeSumSmaller(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) return 0
    val sorted = nums.sorted

    @scala.annotation.tailrec
    def f(left: Int, right: Int, target: Int, acc: Int): Int =
      if (left >= right) acc
      else if (sorted(left) + sorted(right) < target) f(left + 1, right, target, acc + right - left)
      else f(left, right - 1, target, acc)

    sorted.indices.dropRight(2).foldLeft(0)((count, i) => count + f(i + 1, sorted.length - 1, target - sorted(i), 0))
  }
}
