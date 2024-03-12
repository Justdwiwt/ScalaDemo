package leetCode._300

object Solution_265 {
  def minCostII(costs: Array[Array[Int]]): Int = {
    if (costs.isEmpty) return 0
    (1 until costs.length).foreach(i => costs(0).indices.foreach(j => costs(i)(j) += find(costs(i - 1), j)))
    var res = Int.MaxValue
    costs(0).indices.foreach(i => if (costs(costs.length - 1)(i) < res) res = costs(costs.length - 1)(i))
    res
  }

  def find(cost: Array[Int], idx: Int): Int = {
    var mn = Int.MaxValue
    cost.indices.foreach(i => if (i != idx && cost(i) < mn) mn = cost(i))
    mn
  }
}
