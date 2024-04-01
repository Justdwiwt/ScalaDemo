package leetCode._900

object Solution_810 {
  def xorGame(nums: Array[Int]): Boolean =
    nums.foldLeft(0)((acc, cur) => acc ^ cur) == 0 || nums.length % 2 == 0
}
