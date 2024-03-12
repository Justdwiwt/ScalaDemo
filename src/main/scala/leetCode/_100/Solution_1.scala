package leetCode._100

object Solution_1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    nums.zipWithIndex./:(Map[Int, Int]()) { case (m, p@(x, j)) => m.get(target - x).map(i => return Array(i, j)).getOrElse(m + p) }
    Array(0, 0)
  }
}
