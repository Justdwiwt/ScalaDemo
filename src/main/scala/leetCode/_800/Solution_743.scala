package leetCode._800

object Solution_743 {
  def networkDelayTime(times: Array[Array[Int]], n: Int, k: Int): Int = {
    val dist = Array.tabulate(n + 1)(i => if (i == k) 0 else Int.MaxValue)

    (0 until n).foreach(_ => times
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .withFilter { case Array(u, _, _) => dist(u) != Int.MaxValue }
      .foreach { case Array(u, v, w) => dist(v) = dist(v).min(dist(u) + w) })

    val maxDist = dist.tail.max
    if (maxDist < Int.MaxValue) maxDist else -1
  }
}
