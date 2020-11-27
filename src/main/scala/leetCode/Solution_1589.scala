package leetCode

object Solution_1589 {
  def maxSumRangeQuery(nums: Array[Int], requests: Array[Array[Int]]): Int = {
    var cnt = Array.fill(nums.length)(0L)
    requests.foreach(r => {
      cnt(r.head) += 1
      if (r(1) + 1 < nums.length) cnt(r(1) + 1) -= 1
    })
    nums.indices.drop(1).foreach(i => cnt(i) += cnt(i - 1))
    val sorted = nums.sorted
    cnt = cnt.sorted
    var res = 0L
    nums.indices.foreach(i => res = (res + (sorted(i) * cnt(i))) % 1000000007)
    res.toInt
  }
}
