package leetCode._2800

object Solution_2717 {
  def semiOrderedPermutation(nums: Array[Int]): Int = {
    val (i, j) = (nums.indexOf(nums.min), nums.indexOf(nums.max))
    i + nums.length - j - (if (i < j) 1 else 2)
  }
}
