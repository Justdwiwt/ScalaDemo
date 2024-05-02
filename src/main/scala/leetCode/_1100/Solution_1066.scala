package leetCode._1100

object Solution_1066 {
  private var workers: Array[Array[Int]] = _
  private var bikes: Array[Array[Int]] = _

  def assignBikes(workers: Array[Array[Int]], bikes: Array[Array[Int]]): Int = {
    this.workers = workers
    this.bikes = bikes
    val m = bikes.length
    val dp = Array.fill(1 << m)(0)
    dfs(0, 0, dp)
  }

  private def dfs(idx: Int, state: Int, dp: Array[Int]): Int = {
    if (idx == workers.length) return 0
    val res = if (dp(state) != 0) dp(state)
    else bikes
      .indices
      .filter(i => (state & (1 << i)) == 0)
      .map(i => dfs(idx + 1, state | (1 << i), dp) + manDis(idx, i))
      .min
    dp(state) = res
    res
  }

  private def manDis(i: Int, j: Int): Int =
    (workers(i).head - bikes(j).head).abs + (workers(i)(1) - bikes(j)(1)).abs
}
