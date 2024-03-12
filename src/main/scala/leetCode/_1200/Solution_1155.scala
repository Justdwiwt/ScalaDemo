package leetCode._1200

import scala.collection.mutable

object Solution_1155 {
  def numRollsToTarget(d: Int, f: Int, target: Int): Int = {
    val M = 1000000007
    val m = mutable.HashMap.empty[(Int, Int), Long]

    def go(d: Int, t: Int): Long =
      if (d == 0 && t == 0) 1L
      else if (d == 0 || t == 0) 0L
      else m.getOrElseUpdate((d, t), (1 to f).map(i => go(d - 1, t - i)).sum % M)

    (go(d, target) % M).toInt
  }
}
