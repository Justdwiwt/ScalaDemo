package leetCode._1000

object Solution_995 {
  def minKBitFlips(nums: Array[Int], k: Int): Int = {
    @scala.annotation.tailrec
    def f(index: Int, flipped: Int, res: Int, isFlipped: Vector[Int]): (Int, Boolean) =
      if (index >= nums.length) (res, true)
      else {
        val newFlipped = if (index >= k) flipped ^ isFlipped(index - k) else flipped
        if (newFlipped == nums(index)) {
          if (index + k > nums.length) (res, false)
          else f(index + 1, newFlipped ^ 1, res + 1, isFlipped.updated(index, 1))
        } else f(index + 1, newFlipped, res, isFlipped)
      }

    val (res, valid) = f(0, 0, 0, Vector.fill(nums.length)(0))
    if (valid) res else -1
  }
}
