package leetCode._2100

object Solution_2036 {
  def maximumAlternatingSubarraySum(nums: Array[Int]): Long = {
    if (nums.length == 1) return nums.head.toLong
    nums.drop(1).map(BigInt(_)).foldLeft((BigInt(nums.head), BigInt(nums.head), BigInt(0))) {
      case ((maxSum, curA, curB), num) =>
        val newA = num.max(curB + num)
        val newB = BigInt(0).max(curA - num)
        (maxSum.max(newA).max(newB), newA, newB)
    }._1.toLong
  }
}
