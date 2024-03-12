package leetCode._2500

object Solution_2460 {
  def applyOperations(nums: Array[Int]): Array[Int] = {
    def f(i: Int): Array[Int] =
      if (i == nums.length) Array.empty
      else if (i == nums.indices.last) Array(nums.last)
      else if (nums(i) == 0) f(i + 1)
      else if (nums(i) != nums(i + 1)) nums(i) +: f(i + 1)
      else (nums(i + 1) * 2) +: f(i + 2)

    f(0).padTo(nums.length, 0)
  }
}
