package leetCode._3000

import scala.collection.mutable

object Solution_2941 {
  // fixme: case 1036/1059 data limit exceeded
  @scala.annotation.tailrec
  private def gcd(a: Long, b: Long): Long =
    if (b == 0) a else gcd(b, a % b)

  def maxGcdSum(nums: Array[Int], k: Int): Int = {
    var res = if (k == 1) nums.map(_.toLong).max * nums.map(_.toLong).max else 0L
    var m = mutable.Map.empty[Long, (Long, Int)]

    nums.map(_.toLong).foreach(num => {
      val g2 = mutable.Map(num -> (num, 1))
      for ((g, (gSum, gLen)) <- m) {
        val gNext = gcd(g, num)
        if (!(g2.contains(gNext) && g2(gNext)._1 > num + gSum))
          g2(gNext) = (num + gSum, gLen + 1)
        if (g2(gNext)._2 >= k && g2(gNext)._1 * gNext > res)
          res = g2(gNext)._1 * gNext
      }
      m = g2
    })
    res.toInt
  }
}
