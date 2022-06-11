package leetCode

object Solution_2272 {
  def largestVariance(s: String): Int = {
    val freq = s.groupBy(identity).mapValues(_.length)
    s
      .distinct
      .toArray
      .combinations(2)
      .flatMap(arr => Array(arr, arr.reverse))
      ./:(0) { case (maxVariance, Array(a, b)) => s
        ./:(maxVariance, freq(a), 0, 0) { case ((maxVariance, remA, currA, currB), c) =>
          val newCurrB = if (c == b) currB + 1 else currB
          val (newRemA, newCurrA) = if (c == a) (remA - 1, currA + 1) else (remA, currA)
          val newMaxVariance = if (newCurrA > 0) maxVariance.max(newCurrB - newCurrA) else maxVariance
          if (newCurrB < newCurrA && newRemA >= 1) (newMaxVariance, newRemA, 0, 0)
          else (newMaxVariance, newRemA, newCurrA, newCurrB)
        }._1
      }
  }
}
