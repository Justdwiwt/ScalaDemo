package leetCode._100

object Solution_46 {
  def permute(nums: Array[Int]): List[List[Int]] =
    if (nums.isEmpty) Nil
    else nums.toList.permutations.toList
}
