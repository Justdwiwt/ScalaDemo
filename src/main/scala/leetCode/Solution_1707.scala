package leetCode

object Solution_1707 {
  def maximizeXor(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val sorted = nums.sorted
    val res = Array.fill(queries.length)(0)
    queries.indices.foreach(i => res(i) = getMax(sorted, queries(i).head, queries(i)(1)))
    res
  }

  def getMax(nums: Array[Int], x: Int, m: Int): Int = {
    if (nums.head > m) return -1
    var l = 0
    var r = java.util.Arrays.binarySearch(nums, m + 1)

    if (r < 0) r = -(r + 1)

    var bp = 30
    var base = 0

    while (bp >= 0 && (0x1 << bp) > m) bp -= 1

    while (bp >= 0 && l < r) {
      var bv = base + (0x1 << bp)
      var p = java.util.Arrays.binarySearch(nums, l, r, bv)

      if (p < 0) p = -(p + 1)
      else while (p > 0 && nums(p) == nums(p - 1)) p -= 1

      if (((0x1 << bp) & x) == 0) {
        if (p < r) {
          base |= bv
          l = p
        }
      } else {
        if (p > l) r = p
        else base |= bv
      }
      bp -= 1
    }
    nums(l) ^ x
  }
}
