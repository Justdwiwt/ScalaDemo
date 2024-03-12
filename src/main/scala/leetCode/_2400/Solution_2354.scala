package leetCode._2400

object Solution_2354 {
  def countExcellentPairs(nums: Array[Int], k: Int): Long = {
    val cnt = nums.distinct.groupBy(f).mapValues(_.length)
    cnt./:(0L) { case (totalCount, (hammingWeight1, count1)) =>
      cnt./:(totalCount) { case (totalCount, (hammingWeight2, count2)) =>
        if (hammingWeight1 + hammingWeight2 < k) totalCount
        else totalCount + count1 * count2
      }
    }
  }

  private def f(n: Int): Int = (0 to 31)
    ./:(0)((cnt, shift) => cnt + (n >> shift & 1))
}
