package leetCode._3400

object Solution_3396 {
  def minimumOperations(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(seen: Set[Int], i: Int): Int =
      if (i < 0) 0
      else {
        val x = nums(i)
        if (seen.contains(x)) (i / 3) + 1
        else f(seen + x, i - 1)
      }

    f(Set.empty, nums.length - 1)
  }
}
