package leetCode._4100

object Solution_4010 {
  def maxPairStrength(nums: Array[Int]): Long = nums
    .indices
    .flatMap(i => (i + 1 until nums.length)
      .map(j => {
        val g = gcd(nums(i), nums(j)).toLong
        nums(i).toLong * nums(j) / g / g
      })
    ).max

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
