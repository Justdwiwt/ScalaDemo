package leetCode._2100

object Solution_2057 {
  def smallestEqual(nums: Array[Int]): Int = nums
    .zipWithIndex
    .indexWhere(x => x._2 % 10 == x._1)
}
