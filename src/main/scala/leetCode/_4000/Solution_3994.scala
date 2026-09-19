package leetCode._4000

object Solution_3994 {
  def minAdjacentSwaps(nums: Array[Int], a: Int, b: Int): Int = {
    val (_, _, ans) = nums.foldLeft((0L, 0L, 0L)) {
      case ((cnt1, cnt2, ans), x) =>
        if (x < a) (cnt1, cnt2, ans + cnt1 + cnt2)
        else if (x <= b) (cnt1 + 1, cnt2, ans + cnt2)
        else (cnt1, cnt2 + 1, ans)
    }

    (ans % 1000000007L).toInt
  }
}
