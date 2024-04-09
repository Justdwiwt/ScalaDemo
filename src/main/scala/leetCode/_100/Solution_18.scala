package leetCode._100

object Solution_18 {
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    solve(nums.sorted, target)
  }

  private def solve(nums: Array[Int], target: Int): List[List[Int]] = {
    nums.indices.flatMap(i =>
      f(i + 1, nums, target - nums(i)) match {
        case Nil => Nil
        case l => l.map(nums(i) :: _)
      }).filter(_.nonEmpty).toList.distinct
  }

  private def f(i: Int, nums: Array[Int], target: Int): List[List[Int]] = {
    (i until nums.length).flatMap(i =>
      g(i + 1, nums, target - nums(i)) match {
        case l => l.map(nums(i) :: _)
      }).filter(_.nonEmpty).toList
  }

  private def g(i: Int, nums: Array[Int], target: Int): List[List[Int]] = {
    (i until nums.length).flatMap(x =>
      (x + 1 until nums.length).withFilter(nums(x) + nums(_) == target)
        .map(y => List(nums(x), nums(y)))).filter(_.nonEmpty).toList
  }

  def k(nums: Array[Int], target: Int): List[List[Int]] = {
    nums.indices.flatMap(i =>
      (i + 1 until nums.length).flatMap(j =>
        (j + 1 until nums.length).flatMap(k =>
          (k + 1 until nums.length).withFilter(nums(i) + nums(j) + nums(k) + nums(_) == target)
            .map(l => List(nums(i), nums(j), nums(k), nums(l)))
        )
      )
    ).toSet.toList
  }
}
