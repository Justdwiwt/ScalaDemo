package leetCode

object Solution_3022 {
  def minOrAfterOperations(nums: Array[Int], k: Int): Int = (31 to 0 by -1)./:(0)((res, bit) => {
    val available = res | (1 << bit) - 1
    val (_, cnt) = nums./:((1 << 31) - 1, 0) { case ((mask, cnt), n) =>
      if ((mask & n | available) == available) ((1 << 31) - 1, cnt + 1)
      else (mask & n, cnt)
    }
    if (nums.length - cnt > k) res | (1 << bit) else res
  })
}
