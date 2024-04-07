package leetCode._300

object Solution_265 {
  def minCostII(costs: Array[Array[Int]]): Int = {
    if (costs.isEmpty) return 0
    costs.indices.drop(1).foreach(i => costs.head.indices.foreach(j => costs(i)(j) += find(costs(i - 1), j)))
    costs.head.indices.map(costs(costs.length - 1)(_)).min
  }

  private def find(cost: Array[Int], idx: Int): Int =
    cost.indices.filter(_ != idx).map(cost).min
}
