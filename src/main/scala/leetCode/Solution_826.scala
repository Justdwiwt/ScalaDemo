package leetCode

import scala.collection.mutable

object Solution_826 {
  def maxProfitAssignment(difficulty: Array[Int], profit: Array[Int], worker: Array[Int]): Int = {
    var m = new mutable.HashMap[Int, Int]()
    difficulty.indices.foreach(i => m += profit(i) -> m.getOrElse(profit(i), Int.MaxValue).min(difficulty(i)))
    val profitSorted = profit.sorted
    val workerSorted = worker.sorted
    var wIdx = workerSorted.length - 1
    var pIdx = profitSorted.length - 1
    var res = 0
    while (pIdx >= 0 && wIdx >= 0) {
      val p = m(profitSorted(pIdx))
      val w = workerSorted(wIdx)
      if (p > w) pIdx -= 1
      else {
        res += profitSorted(pIdx)
        wIdx -= 1
      }
    }
    res
  }
}
