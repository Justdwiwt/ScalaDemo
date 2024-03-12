package leetCode.offer

object Offer_083 {
  def permute(nums: Array[Int]): List[List[Int]] =
    if (nums.isEmpty) Nil
    else nums.toList.permutations.toList
}
