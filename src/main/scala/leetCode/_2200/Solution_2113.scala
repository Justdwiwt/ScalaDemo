package leetCode._2200

object Solution_2113 {
  def elementInNums(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val len = nums.length
    val n = queries.length
    val res = Array.fill(n)(0)
    val T = 2 * len
    queries.indices.foreach(i => {
      val t = queries(i).head % T
      if (t < len) {
        val idx = queries(i)(1) + t
        res(i) = if (idx >= len) -1 else nums(idx)
      } else {
        val idx = queries(i)(1)
        res(i) = if (idx >= (t - len)) -1 else nums(idx)
      }
    })
    res
  }
}
