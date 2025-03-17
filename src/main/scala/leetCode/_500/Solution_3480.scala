package leetCode._500

object Solution_3480 {
  def maxSubarrays(n: Int, conflictingPairs: Array[Array[Int]]): Long = {
    val groups = conflictingPairs.foldLeft(Map.empty[Int, List[Int]].withDefaultValue(Nil)) {
      case (acc, Array(a, b)) =>
        val (minA, maxB) = if (a > b) (b, a) else (a, b)
        acc.updated(minA, maxB :: acc(minA))
    }

    @scala.annotation.tailrec
    def compute(a: Int, b: List[Int], ans: Long, extra: Map[Int, Long]): Long =
      if (a == 0) ans + extra.values.reduceOption(_.max(_)).getOrElse(0L)
      else {
        val newB = (b ++ groups(a)).sorted.take(2)
        val newAns = ans + (newB.head - a).toLong
        val newExtra = extra.updated(newB.head, extra.getOrElse(newB.head, 0L) + (newB(1) - newB.head).toLong)
        compute(a - 1, newB, newAns, newExtra)
      }

    compute(n, List(n + 1, n + 1), 0L, Map.empty.withDefaultValue(0L))
  }
}
