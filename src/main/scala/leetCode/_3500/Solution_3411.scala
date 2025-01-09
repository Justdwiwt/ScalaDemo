package leetCode._3500

object Solution_3411 {
  def maxLength(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def gcd(a: Long, b: Long): Long =
      if (b == 0) a else gcd(b, a % b)

    def lcm(a: Long, b: Long): Long =
      (a * b) / gcd(a, b)

    nums.indices.foldLeft(0)((ans, i) => {
      val (_, _, _, maxLen) = (i + 1 until nums.length).foldLeft((nums(i).toLong, nums(i).toLong, nums(i).toLong, ans)) {
        case ((gcdVal, lcmVal, prod, maxLen), j) =>
          val newProd = prod * nums(j).toLong
          if (newProd > 100000000000L) (gcdVal, lcmVal, newProd, maxLen)
          else {
            val newGcdVal = gcd(gcdVal, nums(j).toLong)
            val newLcmVal = lcm(lcmVal, nums(j).toLong)
            val newMaxLen = if (newProd == newGcdVal * newLcmVal) maxLen.max(j - i + 1) else maxLen
            (newGcdVal, newLcmVal, newProd, newMaxLen)
          }
      }
      ans.max(maxLen)
    })
  }
}
