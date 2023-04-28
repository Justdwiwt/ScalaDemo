package leetCode

object Solution_2644 {
  def maxDivScore(nums: Array[Int], divisors: Array[Int]): Int = divisors./:(Int.MaxValue, 0)((acc, cur) => {
    val cnt = nums.count(_ % cur == 0)
    if (cnt > acc._2 || (cnt == acc._2 && cur < acc._1)) (cur, cnt)
    else acc
  })._1
}
