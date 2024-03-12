package leetCode._2700

object Solution_2653 {
  def getSubarrayBeauty(nums: Array[Int], k: Int, x: Int): Array[Int] = {
    val cnt = Array.fill(50)(0)
    val res = Array.fill(nums.length - k + 1)(0)

    @scala.annotation.tailrec
    def f(j: Int, total: Int): Int =
      if (j == 50) 0
      else if (total + cnt(j) >= x) j - 50
      else f(j + 1, total + cnt(j))

    nums.indices.foreach(i => {
      if (nums(i) < 0) cnt(nums(i) + 50) += 1
      if (i - k >= 0 && nums(i - k) < 0) cnt(nums(i - k) + 50) -= 1
      if (i - k + 1 >= 0) res(i - k + 1) = f(0, 0)
    })

    res
  }
}
