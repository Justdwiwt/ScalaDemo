package leetCode

import scala.collection.mutable

object Solution_846 {
  def isNStraightHand(hand: Array[Int], W: Int): Boolean = {
    if (hand.length % W != 0) return false
    val tm = new mutable.TreeMap[Int, Int]()
    hand.foreach(i => tm.put(i, tm.getOrElse(i, 0) + 1))
    var cur = 0
    while (tm.nonEmpty) {
      cur = tm.firstKey
      (cur until cur + W).foreach(i => {
        if (!tm.contains(i)) return false
        else {
          val t = tm(i)
          if (t == 1) tm.remove(i)
          else tm.put(i, t - 1)
        }
      })
    }
    true
  }
}
