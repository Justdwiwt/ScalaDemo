package leetCode._2400

object Solution_2389 {
  def answerQueries(nums: Array[Int], queries: Array[Int]): Array[Int] = {
    val pre = nums.sorted.scanLeft(0)(_ + _)

    def f(target: Int): Int =
      pre.takeWhile(_ <= target).length - 1

    queries.map(f)
  }
}
