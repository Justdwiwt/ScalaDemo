package leetCode._2800

object Solution_2717 {
  def semiOrderedPermutation(nums: Array[Int]): Int =
    if (nums.indexOf(1) < nums.indexOf(nums.length)) nums.indexOf(1) + nums.length - nums.indexOf(nums.length) - 1
    else nums.indexOf(1) + nums.length - nums.indexOf(nums.length) - 2
}
