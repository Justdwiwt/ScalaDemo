package leetCode._200

object Solution_179 {
  def largestNumber(nums: Array[Int]): String =
    BigInt(nums.map(_.toString).sortWith((l, r) => l ++ r >= r ++ l)./:("")(_ + _)).toString
}
