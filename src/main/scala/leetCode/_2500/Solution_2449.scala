package leetCode._2500

object Solution_2449 {
  def makeSimilar(nums: Array[Int], target: Array[Int]): Long = {
    val sortedNums = nums.sortBy(n => (n % 2, n))
    val sortedTarget = target.sortBy(n => (n % 2, n))
    sortedNums.zip(sortedTarget).map { case (n, t) => (n - t).abs.toLong }.sum / 4
  }
}
