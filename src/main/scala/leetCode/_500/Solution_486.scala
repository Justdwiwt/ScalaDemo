package leetCode._500

object Solution_486 {
  def predictTheWinner(nums: Array[Int]): Boolean = {
    def f(lo: Int, hi: Int, turn: Int): Int =
      if (hi == lo) nums(lo) * turn
      else (nums(lo) - f(lo + 1, hi, -turn)).max(nums(hi) - f(lo, hi - 1, -turn))

    f(0, nums.length - 1, 1) >= 0
  }
}
