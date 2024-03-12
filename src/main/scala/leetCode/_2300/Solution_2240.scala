package leetCode._2300

object Solution_2240 {
  def waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long = (0 to total / cost1)
    .iterator
    .map(n => (total - n.toLong * cost1) / cost2 + 1)
    .sum
}
