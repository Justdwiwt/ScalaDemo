package leetCode._3800

object Solution_3789 {
  def minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long = {
    val both = math.min(need1, need2).toLong * math.min(costBoth, cost1 + cost2)
    val diff = (need1 - need2).toLong
    both + (if (diff > 0) diff * math.min(costBoth, cost1) else -diff * math.min(costBoth, cost2))
  }
}
