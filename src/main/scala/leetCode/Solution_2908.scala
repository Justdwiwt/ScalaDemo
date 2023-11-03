package leetCode

object Solution_2908 {
  def minimumSum(nums: Array[Int]): Int = scala
    .util
    .Try(nums.indices
      .flatMap(i => ((i + 1) until nums.length)
        .flatMap(j => ((j + 1) until nums.length)
          .withFilter(k => nums(i) < nums(j) && nums(k) < nums(j))
          .map(k => nums(i) + nums(j) + nums(k)))).min)
    .getOrElse(-1)
}
