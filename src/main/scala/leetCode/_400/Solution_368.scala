package leetCode._400

object Solution_368 {
  def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
    if (nums.length == 0) return Nil
    val A = nums.sorted
    val n = A.length
    val dp = Array.fill(n)(List.empty[Int])
    (0 until n).foreach(i => {
      dp(i) = A(i) :: Nil
      (0 until i).withFilter(A(i) % A(_) == 0).foreach(j =>
        if (dp(j).length + 1 > dp(i).length) dp(i) = A(i) :: dp(j))
    })
    dp.minBy(-_.length).reverse
  }
}
