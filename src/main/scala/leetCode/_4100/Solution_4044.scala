package leetCode._4100

object Solution_4044 {
  def countGoodRotations(nums: Array[Int]): Int = {
    val n = nums.length
    val s = (nums ++ nums).scanLeft(0L)(_ + _)

    (n until 2 * n).count(i => s(i - n / 2) * 2 > s(i) + s(i - n))
  }
}
