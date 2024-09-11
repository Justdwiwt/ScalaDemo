package leetCode._3300

object Solution_3282 {
  def findMaximumScore(nums: List[Int]): Long = {
    val bigIntList = nums.map(BigInt(_))

    def max(a: BigInt, b: BigInt): BigInt =
      if (a > b) a else b

    bigIntList.init.scanLeft(bigIntList.head)(max).tail.sum.toLong
  }
}
