package leetCode._4100

object Solution_4041 {
  def minOperations(nums: Array[Int], sum: Int): Int = {
    val inf = Int.MaxValue / 2

    def items(x: Int): Map[Int, Int] = (0 until 32)
      .withFilter(a => (x >> a) > 0)
      .flatMap(a => (0 until 32)
        .map { b => val v = (x >> a) << b; (b, v) }
        .withFilter { case (_, v) => v > 0 && v <= sum }
        .map { case (b, v) => v -> (a + b) })
      .groupBy(_._1)
      .map { case (v, pairs) => v -> pairs.map(_._2).min }

    def update(f: Array[Int], x: Int): Array[Int] = {
      val costs = items(x).toArray.sortBy(_._1)

      (sum to 1 by -1).foreach { i =>
        costs.takeWhile(_._1 <= i).foreach {
          case (v, c) =>
            f(i) = math.min(f(i), f(i - v) + c)
        }
      }
      f
    }

    val f = Array.fill(sum + 1)(inf)
    f(0) = 0

    nums.foldLeft(f)(update) match {
      case dp if dp(sum) >= inf => -1
      case dp => dp(sum)
    }
  }
}
