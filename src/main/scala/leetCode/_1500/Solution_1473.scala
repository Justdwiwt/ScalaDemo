package leetCode._1500

import scala.collection.mutable

object Solution_1473 {
  def minCost(houses: Array[Int], cost: Array[Array[Int]], m: Int, n: Int, target: Int): Int = {
    val map = mutable.HashMap[(Int, Int, Int), Int]()

    def f(h: Array[Int], co: Array[Array[Int]], m: Int, n: Int, target: Int, i: Int, prev: Int, nei: Int): Int = {
      if (i == m)
        if (nei == target) 0
        else Int.MaxValue
      else map.get((i, prev, nei)) match {
        case Some(v) => v
        case None =>
          if (h(i) == 0) {
            val r = (0 until n).map(j => {
              val v = f(h, co, m, n, target, i + 1, j + 1, if (prev == j + 1) nei else nei + 1)
              if (v == Int.MaxValue) Int.MaxValue
              else v + co(i)(j)
            }).min
            map += (i, prev, nei) -> r
          } else map += (i, prev, nei) -> f(h, co, m, n, target, i + 1, h(i), if (prev == h(i)) nei else nei + 1)
          map((i, prev, nei))
      }
    }

    val res = f(houses, cost, m, n, target, 0, -1, 0)
    if (res == Int.MaxValue) -1 else res
  }
}
