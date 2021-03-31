package leetCode

object Solution_90 {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] =
    Nil :: nums.indices.flatMap(i => nums.combinations(i + 1).map(_.toList)).toList.distinct
}
