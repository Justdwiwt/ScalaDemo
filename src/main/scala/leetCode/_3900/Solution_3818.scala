package leetCode._3900

object Solution_3818 {
  def minimumPrefixLength(nums: Array[Int]): Int =
    nums.length - nums.reverse.zip(nums.reverse.drop(1)).takeWhile(n => n._1 > n._2).length - 1
}
