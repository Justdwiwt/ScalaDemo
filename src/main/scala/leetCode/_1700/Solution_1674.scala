package leetCode._1700

object Solution_1674 {
  def minMoves(nums: Array[Int], limit: Int): Int = {
    val arr = new Array[Int](2 * limit + 2)
    (0 until nums.length / 2).foreach(i => {
      val a = nums(i)
      val b = nums(nums.length - 1 - i)
      val min = a.min(b)
      val max = a.max(b)
      arr(2) += 2
      arr(min + 1) -= 1
      arr(min + max) -= 1
      arr(min + max + 1) += 1
      arr(max + limit + 1) += 1
    })
    var cur = 0
    var res = 2 * nums.length
    (2 to 2 * limit).foreach(i => {
      cur += arr(i)
      res = res.min(cur)
    })
    res
  }
}
