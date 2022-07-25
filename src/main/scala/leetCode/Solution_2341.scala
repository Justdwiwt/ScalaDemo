package leetCode

object Solution_2341 {
  def numberOfPairs(nums: Array[Int]): Array[Int] = nums
    .groupBy(identity)
    .mapValues(_.length)
    ./:(Array(0, 0)) { case (res, (_, cnt)) => Array(res.head + cnt / 2, res(1) + cnt % 2) }
}
