package leetCode._900

import scala.collection.mutable

object Solution_879 {
  def profitableSchemes(g: Int, p: Int, groups: Array[Int], profits: Array[Int]): Int = {
    assert(groups.length == profits.length)
    val cnt = mutable.IndexedSeq.tabulate(groups.length + 1, g + 1, p + 1) {
      case (0, _, 0) => 1
      case (0, _, _) => 0
      case _ => -1
    }
    (1 to groups.length).foreach(i => (0 to g).foreach(j => (0 to p).foreach(k => cnt(i)(j)(k) = (groups(i - 1), profits(i - 1)) match {
      case (group, profit) if group <= j => (cnt(i - 1)(j - group)(0.max(k - profit)) + cnt(i - 1)(j)(k)) % 1000000007
      case _ => cnt(i - 1)(j)(k)
    })))
    cnt(groups.length)(g)(p)
  }
}
