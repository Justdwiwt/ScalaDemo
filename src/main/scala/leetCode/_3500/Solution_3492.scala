package leetCode._3500

object Solution_3492 {
  def maxContainers(n: Int, w: Int, maxWeight: Int): Int =
    if (maxWeight / w > n * n) n * n else maxWeight / w
}
