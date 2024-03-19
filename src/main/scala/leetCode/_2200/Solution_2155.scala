package leetCode._2200

object Solution_2155 {
  def maxScoreIndices(nums: Array[Int]): List[Int] = {
    val zeroesToTheLeft = nums.scanLeft(0)((cnt, n) => cnt + (if (n == 0) 1 else 0))
    val onesToTheRight = nums.scanRight(0)((n, cnt) => cnt + (if (n == 1) 1 else 0))

    (0 to nums.length)
      .groupBy(i => zeroesToTheLeft(i) + onesToTheRight(i))
      .maxBy { case (cnt, _) => cnt }
      ._2
      .toList
  }
}
