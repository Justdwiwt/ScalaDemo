package leetCode._3700

import java.util

object Solution_3661 {
  def maxWalls(robots: Array[Int], distance: Array[Int], walls: Array[Int]): Int = {
    val n = robots.length
    val a = (0 -> 0) +: robots.zip(distance).sortBy(_._1) :+ (Int.MaxValue -> 0)
    val ws = walls.sorted

    def lb(x: Int) = {
      val p = util.Arrays.binarySearch(ws, x)
      if (p >= 0) p else -p - 1
    }

    def ub(x: Int) = {
      val p = util.Arrays.binarySearch(ws, x)
      if (p >= 0) Stream.from(p).takeWhile(i => i < ws.length && ws(i) == x).last + 1
      else -p - 1
    }

    (1 to n).foldLeft((0, 0)) { case ((f0, f1), i) =>
      val (x, d) = a(i)
      val leftX = math.max(x - d, a(i - 1)._1 + 1)
      val left = lb(leftX)
      val curA = ub(x)
      val leftRes = f0 + (curA - left)

      val curB = lb(x)
      val (x2, d2) = a(i + 1)

      val r0 = math.min(x + d, (x2 - d2) - 1)
      val r1 = math.min(x + d, x2 - 1)

      val right0 = ub(r0)
      val right1 = ub(r1)

      val g0 = math.max(leftRes, f1 + (right0 - curB))
      val g1 = math.max(leftRes, f1 + (right1 - curB))
      (g0, g1)
    }._2
  }
}
