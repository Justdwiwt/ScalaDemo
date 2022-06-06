package leetCode

object Solution_2293 {
  def minMaxGame(nums: Array[Int]): Int = {
    var n = nums.length
    while (n > 1) {
      (0 until n / 2).foreach(i => {
        if ((i & 1) == 0) nums(i) = nums(i << 1).min(nums((i << 1) + 1))
        else nums(i) = nums(i << 1).max(nums((i << 1) + 1))
      })
      n >>= 1
    }
    nums.head
  }
}
