package leetCode.offer

object Offer_010 {
  def subarraySum(nums: Array[Int], k: Int): Int = nums
    .scanLeft(0)(_ + _)
    ./:(Map.empty[Int, Int], 0: Int) {
      case ((pre, cnt), sum) =>
        if (pre.contains(sum - k)) (pre + (sum -> (pre.getOrElse(sum, 0) + 1)), cnt + pre.getOrElse(sum - k, 0))
        else (pre + (sum -> (pre.getOrElse(sum, 0) + 1)), cnt)
    }._2
}
