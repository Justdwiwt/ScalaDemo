package leetCode.offer

object Offer_104 {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val arr = Array.fill(target + 1)(0)
    arr(0) = 1
    (1 to target).foreach(i => arr(i) = nums.map(i - _).filter(_ >= 0).map(arr(_)).sum)
    arr(target)
  }
}
