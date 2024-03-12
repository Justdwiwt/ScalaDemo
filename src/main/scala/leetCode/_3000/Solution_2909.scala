package leetCode._3000

object Solution_2909 {
  def minimumSum(nums: Array[Int]): Int = {
    val minLeft = nums.scanLeft(Int.MaxValue)(_.min(_)).drop(1)
    val minRight = nums.scanRight(Int.MaxValue)(_.min(_)).dropRight(1)
    val res = nums.indices.drop(1).dropRight(1).flatMap(j => {
      val (l, n, r) = (minLeft(j - 1), nums(j), minRight(j + 1))
      if (l < n && r < n) Some(l + n + r) else None
    })
    if (res.isEmpty) -1 else res.min
  }
}
