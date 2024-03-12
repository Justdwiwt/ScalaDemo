package leetCode._1800

object Solution_1760 {
  def minimumSize(nums: Array[Int], maxOperations: Int): Int = {
    @scala.annotation.tailrec
    def f(i: Int, target: Int, ops: Int): Boolean =
      if (ops < 0) false
      else if (i >= nums.length) true
      else f(i + 1, target, ops - (nums(i) - 1) / target)

    @scala.annotation.tailrec
    def search(lo: Int, hi: Int): Int =
      if (lo < hi) {
        val mid = (lo + hi) >>> 1
        if (f(0, mid, maxOperations)) search(lo, mid)
        else search(mid + 1, hi)
      } else lo

    search(1, nums.max)
  }
}
