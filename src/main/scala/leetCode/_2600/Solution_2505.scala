package leetCode._2600

object Solution_2505 {
  def subsequenceSumOr(nums: Array[Int]): Long =
    (nums.map(_.toLong) ++ nums.scanLeft(0L)(_ + _)).reduce(_ | _)
}
