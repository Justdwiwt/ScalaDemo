package leetCode._3900

object Solution_3833 {
  def dominantIndices(nums: Array[Int]): Int = nums
    .zip(nums.scanRight(0)(_ + _).tail)
    .init
    .foldLeft((0, nums.length - 1)) {
      case ((count, k), (v1, v2)) =>
        if (v1 > v2 / k) (count + 1, k - 1)
        else (count, k - 1)
    }
    ._1
}
