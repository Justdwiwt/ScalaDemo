package leetCode

object Solution_376 {
  def wiggleMaxLength(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def f(pos: Int, posSize: Int, negSize: Int, posNum: Int, negNum: Int): Int =
      if (pos >= nums.length) posSize.max(negSize)
      else {
        val num = nums(pos)
        val (_posSize, _posNum) = if (negNum - num > 0) (negSize + 1, num) else (posSize, posNum)
        val (_negSize, _negNum) = if (posNum - num < 0) (posSize + 1, num) else (negSize, negNum)
        f(pos + 1, _posSize, _negSize, _posNum, _negNum)
      }

    if (nums.length < 2) nums.length else f(1, 1, 1, nums.head, nums.head)
  }
}
