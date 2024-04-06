package leetCode._400

object Solution_334 {
  def increasingTriplet(nums: Array[Int]): Boolean = nums
    .scanLeft(nums.head)(_.min(_))
    .zip(nums)
    .zip(nums.scanRight(nums.last)(_.max(_)).tail)
    .tail
    .exists { case ((min, v), max) => min < v && v < max }
}
