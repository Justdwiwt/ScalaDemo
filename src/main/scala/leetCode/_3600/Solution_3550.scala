package leetCode._3600

object Solution_3550 {
  def smallestIndex(nums: Array[Int]): Int = nums
    .indices
    .find(i => nums(i).abs.toString.map(_.asDigit).sum == i)
    .getOrElse(-1)
}
