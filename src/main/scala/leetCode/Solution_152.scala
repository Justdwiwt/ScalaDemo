package leetCode

object Solution_152 {
  def maxProduct(nums: Array[Int]): Int = {
    val (res, _, _) = nums.drop(1)./:((nums.head, nums.head, nums.head))((t, n) => {
      val mx = Seq(t._2 * n, t._3 * n, n).max
      val mn = Seq(t._2 * n, t._3 * n, n).min
      val r = Seq(t._1, mx, mn).max
      (r, mx, mn)
    })
    res
  }
}
