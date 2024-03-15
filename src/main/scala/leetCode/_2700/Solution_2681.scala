package leetCode._2700

object Solution_2681 {
  def sumOfPower(nums: Array[Int]): Int = {
    val M = (1e9 + 7).toInt
    nums
      .sorted
      .foldLeft(0L, 0L) { case ((res, s), n) => ((res + (s + n) * n % M * n % M) % M, (s * 2 + n) % M) }
      ._1
      .toInt
  }
}
