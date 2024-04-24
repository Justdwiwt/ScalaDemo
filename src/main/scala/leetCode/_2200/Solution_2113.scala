package leetCode._2200

object Solution_2113 {
  def elementInNums(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val n = nums.length
    val res = queries.map(query => {
      val t = query.head % (2 * n)
      if (t < n) {
        val idx = query(1) + t
        if (idx >= n) -1 else nums(idx)
      } else {
        val idx = query(1)
        if (idx >= (t - n)) -1 else nums(idx)
      }
    })
    res
  }
}
