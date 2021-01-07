package leetCode

object Solution_1029 {
  def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
    val sorted = costs.sortBy(_.reduceLeft(_ - _))
    (0 until costs.length / 2).map(i => sorted(i).head + sorted(costs.length / 2 + i)(1)).sum
  }
}
