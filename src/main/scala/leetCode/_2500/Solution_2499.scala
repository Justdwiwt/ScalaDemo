package leetCode._2500

object Solution_2499 {
  def minimumTotalCost(nums1: Array[Int], nums2: Array[Int]): Long = {
    val zipped = nums1.zip(nums2).zipWithIndex

    val (freq, initialCost, initialTotal) = zipped.foldLeft((Map.empty[Int, Int].withDefaultValue(0), 0L, 0)) {
      case ((freq, cost, total), ((x, y), i)) =>
        if (x != y) (freq, cost, total)
        else (freq.updated(x, freq(x) + 1), cost + i, total + 1)
    }

    if (initialTotal == 0) return 0L

    val (maxFreqKey, maxFreq) = freq.maxBy { case (_, freq) => freq }

    val (finalCost, finalTotal, earlyExitCost) = zipped.foldLeft((initialCost, initialTotal, Option.empty[Long])) {
      case ((cost, total, earlyExit), ((x, y), i)) =>
        earlyExit match {
          case Some(exitCost) => (cost, total, Some(exitCost))
          case None =>
            if (2 * maxFreq <= total) (cost, total, Some(cost))
            else if (Seq(x, y, maxFreqKey).distinct.size != 3) (cost, total, None)
            else (cost + i, total + 1, None)
        }
    }

    earlyExitCost.getOrElse(if (2 * maxFreq <= finalTotal) finalCost else -1L)
  }
}
