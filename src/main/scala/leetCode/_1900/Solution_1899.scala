package leetCode._1900

object Solution_1899 {
  def mergeTriplets(triplets: Array[Array[Int]], target: Array[Int]): Boolean = triplets
    .filter(t => t.head <= target.head && t(1) <= target(1) && t(2) <= target(2))
    ./:(Array(0, 0, 0))((cur, t) => Array(cur.head.max(t.head), cur(1).max(t(1)), cur(2).max(t(2))))
    .corresponds(target)(_ == _)
}
