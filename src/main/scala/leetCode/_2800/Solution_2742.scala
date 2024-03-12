package leetCode._2800

object Solution_2742 {
  def paintWalls(cost: Array[Int], time: Array[Int]): Int = {
    val n = cost.length
    val res = Array.fill(n + 5)(1e9.toInt)
    res(0) = 0
    cost.indices.foreach(i => (n to 0 by -1).foreach(j => {
      res(j) = res(j).min(res(0.max(j - time(i) - 1)) + cost(i))
    }))
    res(n)
  }
}
