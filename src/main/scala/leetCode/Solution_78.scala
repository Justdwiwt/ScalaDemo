package leetCode

object Solution_78 {
  def subsets(nums: Array[Int]): List[List[Int]] =
    nums./:(List(List[Int]()))((i, x) => i ++ i.map(lis => x :: lis))
}
