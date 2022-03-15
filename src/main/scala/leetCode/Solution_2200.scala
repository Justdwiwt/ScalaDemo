package leetCode

object Solution_2200 {
  def findKDistantIndices(nums: Array[Int], key: Int, k: Int): List[Int] = {
    @scala.annotation.tailrec
    def f(idx: Int, acc: List[Int]): List[Int] = {
      if (idx == nums.length) return acc.reverse
      if (nums(idx) == key) {
        val n = (acc.headOption.getOrElse(-1) + 1).max(idx - k).max(0) to (idx + k).min(nums.length - 1)
        f(idx + 1, n./:(acc)((a, x) => x :: a))
      } else f(idx + 1, acc)
    }

    f(0, Nil)
  }
}
