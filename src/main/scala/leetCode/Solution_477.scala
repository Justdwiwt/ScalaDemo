package leetCode

object Solution_477 {
  def totalHammingDistance(nums: Array[Int]): Int =
    (0 to 31).map(i => nums.fold(0)((b, c) => b + (c >> i & 1))).fold(0)((d, f) => d + f * (nums.length - f))
}
