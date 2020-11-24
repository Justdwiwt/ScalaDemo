package leetCode

object Solution_1658 {
  def minOperations(nums: Array[Int], x: Int): Int = nums.sum - x match {
    case 0 => nums.length
    case target =>
      @scala.annotation.tailrec
      def find(l: Int, r: Int, cur: Int, res: Int): Int =
        if (r == nums.length) res
        else {
          val next = cur + nums(r)
          if (next > target && l <= r) find(l + 1, r, cur - nums(l), res)
          else if (next == target) find(l + 1, r + 1, next - nums(l), res.max(r - l + 1))
          else find(l, r + 1, next, res)
        }

      find(0, 0, 0, 0) match {
        case 0 => -1
        case l => nums.length - l
      }
  }
}
