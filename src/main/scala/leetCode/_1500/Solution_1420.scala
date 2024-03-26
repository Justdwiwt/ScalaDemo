package leetCode._1500

import scala.collection.mutable

object Solution_1420 {
  def numOfArrays(n: Int, m: Int, k: Int): Int = {
    val M = 1000000007
    val mem = mutable.Map.empty[(Int, Int, Int), Long]

    def f(a: Int, b: Int, c: Int): Long = mem.getOrElseUpdate((a, b, c), {
      if (a == 0) if (b == 0) 1L else 0L
      else {
        val res = (f(a - 1, b, c) * c) % M
        (c + 1 to m).foldLeft(res)((acc, d) => (acc + f(a - 1, b - 1, d)) % M)
      }
    })

    f(n, k, 0).toInt
  }
}
