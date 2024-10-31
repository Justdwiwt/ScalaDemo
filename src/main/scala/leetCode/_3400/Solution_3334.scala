package leetCode._3400

object Solution_3334 {
  @scala.annotation.tailrec
  private def gcd(a: Long, b: Long): Long =
    if (b == 0) a else gcd(b, a % b)

  private def lcm(a: Long, b: Long): Long =
    (a * b) / gcd(a, b)

  def maxScore(nums: Array[Int]): Long = {
    val numsLong = nums.map(_.toLong)

    val sufGcd = numsLong.scanRight(0L)(gcd)
    val sufLcm = numsLong.scanRight(1L)(lcm)

    numsLong.indices.foldLeft((0L, 1L, sufGcd.head * sufLcm.head)) { case ((preGcd, preLcm, res), i) =>
      val currentGcd = gcd(preGcd, sufGcd(i + 1))
      val currentLcm = lcm(preLcm, sufLcm(i + 1))
      val currentMax = currentGcd * currentLcm
      val updatedAns = res.max(currentMax)

      (gcd(preGcd, numsLong(i)), lcm(preLcm, numsLong(i)), updatedAns)
    }._3
  }
}
