package leetCode

object Offer_084 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] =
    if (nums.isEmpty) Nil
    else if (nums.length == 1) List(nums.toList)
    else if (nums.length == 2)
      if (nums.head == nums(1)) List(nums.toList)
      else List(nums.toList, nums.reverse.toList)
    else nums
      .sorted
      .toList
      .map(num => (num, nums.diff(Seq(num)).toList))
      .distinct
      .map({ case (i, j) => val pre = permuteUnique(j.toArray); ((i, j), pre) })
      .map({ case ((i, j), pre) => val res = pre.map(List(i) ++ _); ((i, j), pre, res) })
      .flatMap({ case ((_, _), _, res) => res })
}
