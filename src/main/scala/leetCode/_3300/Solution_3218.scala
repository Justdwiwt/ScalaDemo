package leetCode._3300

object Solution_3218 {
  def minimumCost(m: Int, n: Int, horizontalCut: Array[Int], verticalCut: Array[Int]): Int = {
    val sortedH = horizontalCut.sorted
    val sortedV = verticalCut.sorted

    @scala.annotation.tailrec
    def f(hIndex: Int, vIndex: Int, hCount: Int, vCount: Int, cost: Int): Int = (hIndex, vIndex) match {
      case (hi, vi) if hi >= 0 && vi >= 0 =>
        if (sortedH(hi) >= sortedV(vi)) f(hi - 1, vi, hCount, vCount + 1, cost + sortedH(hi) * hCount)
        else f(hi, vi - 1, hCount + 1, vCount, cost + sortedV(vi) * vCount)
      case (hi, _) if hi >= 0 =>
        f(hi - 1, vIndex, hCount, vCount + 1, cost + sortedH(hi) * hCount)
      case (_, vi) if vi >= 0 =>
        f(hIndex, vi - 1, hCount + 1, vCount, cost + sortedV(vi) * vCount)
      case _ => cost
    }

    f(m - 2, n - 2, 1, 1, 0)
  }
}
