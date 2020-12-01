package leetCode

object Solution_1578 {
  def minCost(s: String, cost: Array[Int]): Int = {
    var res = 0
    s.indices.drop(1).foreach(i => if (s(i) == s(i - 1)) {
      if (cost(i - 1) > cost(i)) {
        res += cost(i)
        cost(i) = cost(i - 1)
      } else res += cost(i - 1)
    })
    res
  }
}
