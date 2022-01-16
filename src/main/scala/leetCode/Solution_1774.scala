package leetCode

object Solution_1774 {
  def closestCost(baseCosts: Array[Int], toppingCosts: Array[Int], target: Int): Int = {

    def decide(cost1: Int, cost2: Int, target: Int): Int =
      if ((cost1 - target).abs < (cost2 - target).abs) cost1
      else if ((cost1 - target).abs > (cost2 - target).abs) cost2
      else cost1.min(cost2)

    def reject(cost: Int, cur: Int, target: Int): Boolean =
      if (((cost - target).abs > (cur - target).abs) && cost > target) false
      else true

    def accept(cost: Int, cur: Int, target: Int): Boolean =
      if (((cost - target).abs < (cur - target).abs) ||
        ((cost - target).abs == (cur - target).abs && cost < cur)) true
      else false


    def backtrack(top: Array[Int], used: Int = 0, target: Int, cur: Int, cost: Int): Int = {
      if (!reject(cost, cur, target)) return cur
      val newCost = if (accept(cost, cur, target)) cost else cur
      if (top.isEmpty) newCost
      else if (used == 0)
        decide(backtrack(top, 1, target, newCost, cost + top.head),
          backtrack(top.tail, 0, target, newCost, cost), target)
      else if (used == 1) decide(backtrack(top.tail, 0, target, cur, cost + top.head),
        backtrack(top.tail, 0, target, cur, cost), target)
      else newCost
    }

    baseCosts.map(x => backtrack(toppingCosts, 0, target, Int.MaxValue, x))./:(Int.MaxValue)((buf, x) => decide(buf, x, target))
  }
}
