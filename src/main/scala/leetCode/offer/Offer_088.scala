package leetCode.offer

object Offer_088 {
  def minCostClimbingStairs(cost: Array[Int]): Int = cost.length match {
    case 0 => 0
    case 1 => cost.head
    case 2 => cost.head.min(cost.last)
    case _ => val finalCost =
      cost.tail.tail.scanLeft((cost.head, cost.tail.head)) { case (acc, v) =>
        (acc._2, acc._1.min(acc._2) + v)
      }.tail.last
      finalCost._1.min(finalCost._2)
  }
}
