package leetCode._2600

object Solution_2505 {
  // fixme: case 38/59 accuracy overflow -> Scala overflows precision when handling bit operations
  def subsequenceSumOr(nums: Array[Int]): Int =
    (nums.iterator ++ nums.scanLeft(0)(_ + _).iterator).reduce(_ | _)
}
