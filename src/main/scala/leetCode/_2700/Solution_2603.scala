package leetCode._2700

import java.util

object Solution_2603 {
  def collectTheCoins(coins: Array[Int], edges: Array[Array[Int]]): Int = {
    val n = coins.length
    val g = Array.fill(n)(new util.ArrayList[Int]())
    val deg = Array.fill(n)(0)
    edges.foreach(e => {
      val x = e.head
      val y = e(1)
      g(x).add(y)
      g(y).add(x)
      deg(x) += 1
      deg(y) += 1
    })

    val q = new util.ArrayDeque[Int]()
    coins.indices.foreach(i => if (deg(i) == 1 && coins(i) == 0) q.add(i))
    while (!q.isEmpty) {
      val x = q.peek()
      q.pop()
      g(x).forEach(y => {
        deg(y) = deg(y) - 1
        if (deg(y) == 1 && coins(y) == 0) q.add(y)
      })
    }

    coins.indices.foreach(i => if (deg(i) == 1 && coins(i) == 1) q.add(i))
    if (q.size() <= 1) return 0
    val time = Array.fill(n)(0)
    while (!q.isEmpty) {
      val x = q.peek()
      q.pop()
      g(x).forEach(y => {
        deg(y) = deg(y) - 1
        if (deg(y) == 1) {
          time(y) = time(x) + 1
          q.add(y)
        }
      })
    }

    var res = 0
    edges.foreach(e => if (time(e.head) >= 2 && time(e(1)) >= 2) res += 2)
    res
  }
}
