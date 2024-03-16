package leetCode._2500

object Solution_2475 {
  def unequalTriplets(nums: Array[Int]): Int = nums
    .groupBy(identity)
    .mapValues(_.length)
    .foldLeft(0, 0, nums.length) { case ((res, l, r), (_, freq)) => (res + l * freq * (r - freq), l + freq, r - freq) }
    ._1
}
