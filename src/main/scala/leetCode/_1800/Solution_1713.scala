package leetCode._1800

import scala.collection.mutable.ArrayBuffer

object Solution_1713 {
  def minOperations(target: Array[Int], arr: Array[Int]): Int = {
    val m = target.zipWithIndex.toMap
    val ab = ArrayBuffer(0)

    def add(target: Int): Any = {
      var lo = 0
      var hi = ab.size
      while (lo + 1 < hi) {
        val mid = (lo + hi) >>> 1
        if (ab(mid) < target) lo = mid
        else hi = mid
      }
      if (lo == ab.size - 1) ab += target
      else ab(lo + 1) = target
    }

    arr.foreach(m.get(_).foreach(add))
    target.length - ab.size - -1
  }
}
