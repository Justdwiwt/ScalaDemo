package leetCode._3000

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_2959 {
  def numberOfSets(n: Int, maxDistance: Int, roads: Array[Array[Int]]): Int = {
    val graph = Array.fill(n, n)(Int.MaxValue / 2)
    (0 until n).foreach(i => graph(i)(i) = 0)
    roads.foreach(road => {
      val from = road.head
      val to = road(1)
      val cost = road(2)
      if (cost < graph(from)(to)) {
        graph(from)(to) = cost
        graph(to)(from) = cost
      }
    })

    var res = 0
    val dp = Array.fill(1 << n, n, n)(Int.MaxValue / 2)
    val queue = mutable.Queue.empty[Array[Int]]

    (0 until (1 << n)).foreach(i => if (Integer.bitCount(i) <= 1) {
      res += 1
      (0 until n).foreach(j => dp(i)(j)(j) = 0)
    } else {
      val list = ArrayBuffer.empty[Int]
      var j = i
      while (j > 0) {
        val index = Integer.bitCount((j & -j) - 1)
        list.append(index)
        j = j & (j - 1)
      }

      val last = list.head
      val pre = dp(i ^ (1 << last))
      (0 until n).foreach(j => (0 until n).foreach(k => dp(i)(j)(k) = pre(j)(k)))

      list.indices.drop(1).foreach(j => {
        val curr = list(j)
        if (graph(last)(curr) < dp(i)(last)(curr)) {
          queue.enqueue(Array(last, curr))
          dp(i)(last)(curr) = graph(last)(curr)
          dp(i)(curr)(last) = graph(last)(curr)
        }
      })

      while (queue.nonEmpty) {
        val xy = queue.dequeue()
        val x = xy(0)
        val y = xy(1)
        list.foreach(v => if (v == x || v == y) ()
        else {
          if (dp(i)(x)(v) > dp(i)(x)(y) + dp(i)(y)(v)) {
            dp(i)(x)(v) = dp(i)(x)(y) + dp(i)(y)(v)
            dp(i)(v)(x) = dp(i)(x)(v)
            queue.enqueue(Array(x, v))
          }

          if (dp(i)(y)(v) > dp(i)(y)(x) + dp(i)(x)(v)) {
            dp(i)(y)(v) = dp(i)(y)(x) + dp(i)(x)(v)
            dp(i)(v)(y) = dp(i)(y)(v)
            queue.enqueue(Array(y, v))
          }
        })
      }

      var allSmall = true
      list.indices.foreach(j => (j + 1 until list.size).foreach(k => if (dp(i)(list(j))(list(k)) > maxDistance) allSmall = false))
      if (allSmall) res += 1
    })
    res
  }
}
