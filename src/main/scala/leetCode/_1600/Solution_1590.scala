package leetCode._1600

import scala.collection.mutable

object Solution_1590 {
  def minSubarray(nums: Array[Int], p: Int): Int = {
    val diff = nums./:(0)((a, b) => (a + b) % p)
    var res = nums.length
    diff match {
      case 0 => 0
      case _ =>
        val m = mutable.HashMap(0 -> -1)
        nums.zipWithIndex./:(0, m) {
          case ((a, b), (num, idx)) =>
            val i = (a + num) % p
            val t = (p - diff + i) % p
            if (b.contains(t)) res = res.min(idx - b(t))
            b(i) = idx
            (i, b)
        }
        if (res < nums.length) res else -1
    }
  }
}
