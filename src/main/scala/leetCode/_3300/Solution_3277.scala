package leetCode._3300

object Solution_3277 {
  def maximumSubarrayXor(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = nums.length

    val arr = Array.fill(n, n)(0)
    val mx = Array.fill(n, n)(0)

    (n - 1 to 0 by -1).foreach(i => {
      mx(i)(i) = nums(i)
      arr(i)(i) = nums(i)
      (i + 1 until n).foreach(j => {
        arr(i)(j) = arr(i)(j - 1) ^ arr(i + 1)(j)
        mx(i)(j) = Seq(arr(i)(j), mx(i + 1)(j), mx(i)(j - 1)).max
      })
    })

    queries.map { case Array(l, r) => mx(l)(r) }
  }
}
