package leetCode._3800

object Solution_3795 {
  def minLength(nums: Array[Int], k: Int): Int = {
    val cnt = collection.mutable.HashMap.empty[Int, Int]
    var sum = 0
    var left = 0

    @scala.annotation.tailrec
    def shrink(right: Int, best: Int): Int =
      if (sum < k) best
      else {
        val nextBest = math.min(best, right - left + 1)
        val out = nums(left)
        cnt.update(out, cnt(out) - 1)
        if (cnt(out) == 0) sum -= out
        left += 1
        shrink(right, nextBest)
      }

    val ans = nums.indices.foldLeft(Int.MaxValue)((best, right) => {
      val x = nums(right)
      cnt.update(x, cnt.getOrElse(x, 0) + 1)
      if (cnt(x) == 1) sum += x
      shrink(right, best)
    })

    if (ans == Int.MaxValue) -1 else ans
  }
}
