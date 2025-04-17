package leetCode._3600

object Solution_3513 {
  def uniqueXorTriplets(nums: Array[Int]): Int =
    if (nums.length <= 2) nums.length
    else 1 << nums.length.toBinaryString.length
}
