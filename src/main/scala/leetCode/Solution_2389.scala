package leetCode

object Solution_2389 {
  def answerQueries(nums: Array[Int], queries: Array[Int]): Array[Int] = {
    val res = Array.fill(queries.length)(0)
    val sorted = nums.sorted
    nums.indices.drop(1).foreach(i => sorted(i) += sorted(i - 1))
    queries.indices.foreach(i => res(i) = f(sorted, queries(i)))
    res
  }

  def f(nums: Array[Int], find: Int): Int = {
    var l = 0
    var r = nums.length - 1
    while (l < r) {
      val m = (l + r) >>> 1
      if (nums(m) == find) return m + 1
      if (nums(m) < find) l = m + 1
      else r = m
    }
    if (nums(l) <= find) l + 1
    else l
  }
}
