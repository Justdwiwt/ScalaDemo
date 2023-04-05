package leetCode

object Solution_2602 {
  def minOperations(nums: Array[Int], queries: Array[Int]): List[Long] = {
    def search(nums: Array[Int], target: Int): Int = {
      @scala.annotation.tailrec
      def f(l: Int, r: Int): Int = {
        val mid = (l + r) >>> 1
        mid match {
          case _ if l > r => l
          case mid if nums(mid) == target => mid
          case mid if nums(mid) < target => f(mid + 1, r)
          case _ => f(l, mid - 1)
        }
      }

      f(0, nums.length - 1)
    }

    val sorted = nums.sorted
    val idx = queries.map(search(sorted, _))
    val pre = sorted.scanLeft(0L)(_ + _)
    idx.indices.map(i => 1L * queries(i) * idx(i) - pre(idx(i)) + pre.last - pre(idx(i)) - 1L * queries(i) * (nums.length - idx(i))).toList
  }
}
