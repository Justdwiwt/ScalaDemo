package leetCode

object Solution_1508 {
  def rangeSum(nums: Array[Int], n: Int, left: Int, right: Int): Int = {
    val M = (1e9 + 7).toInt
    val pq = new java.util.PriorityQueue[Array[Int]](n, (a: Array[Int], b: Array[Int]) => Integer.compare(a(0), b(0)))
    nums.indices.foreach(i => pq.offer(Array(nums(i), i)))
    var res = 0
    var cnt = 1
    while (cnt <= right && !pq.isEmpty) {
      val cur = pq.poll()
      if (cnt >= left) res += cur(0) % M
      if (cur(1) < n - 1) pq.offer(Array(cur(0) + nums(cur(1) + 1), cur(1) + 1))
      cnt += 1
    }
    res
  }
}
