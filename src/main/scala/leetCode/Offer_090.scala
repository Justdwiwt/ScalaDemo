package leetCode

object Offer_090 {
  def rob(nums: Array[Int]): Int = nums
    .headOption
    .map(h => f(nums, 1, nums.length).max(h + f(nums, 2, nums.length - 1)))
    .getOrElse(0)

  def f(nums: Array[Int], i1: Int, i2: Int): Int = nums
    .slice(i1, i2)
    ./:(0, 0)((d, n) => ((n + d._2).max(d._1), d._1))
    ._1
}
