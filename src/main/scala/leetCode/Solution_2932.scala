package leetCode

object Solution_2932 {
  def maximumStrongPairXor(nums: Array[Int]): Int =
    nums.flatMap(x => nums.withFilter(y => (x - y).abs <= x.min(y)).map(x ^ _)).max
}
