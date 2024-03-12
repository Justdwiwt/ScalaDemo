package leetCode._500

object Solution_448 {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] =
    ((1 to nums.length).toSet -- nums.toSet).toList
}
