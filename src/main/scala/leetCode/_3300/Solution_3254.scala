package leetCode._3300

object Solution_3254 {
  def resultsArray(nums: Array[Int], k: Int): Array[Int] = {
    val (_, res) = nums.zipWithIndex.foldLeft((0, Array.fill(nums.length - k + 1)(-1))) {
      case ((cnt, res), (x, i)) =>
        val newCnt = if (i == 0 || x == nums(i - 1) + 1) cnt + 1 else 1
        val updatedRes = if (newCnt >= k) res.updated(i - k + 1, x) else res
        (newCnt, updatedRes)
    }
    res
  }
}
