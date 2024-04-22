package leetCode._2300

import scala.collection.mutable

object Solution_2204 {
  def distanceToCycle(n: Int, edges: Array[Array[Int]]): Array[Int] = {
    val degree = Array.fill(n)(0)
    val graph = Array.fill(n)(mutable.ListBuffer[Int]())

    edges.foreach(edge => {
      graph(edge(0)).append(edge(1))
      graph(edge(1)).append(edge(0))
      degree(edge(0)) += 1
      degree(edge(1)) += 1
    })

    val queue = mutable.Queue[Int]()
    val res = Array.fill(n)(0)

    (0 until n).foreach(i => if (degree(i) == 1) {
      degree(i) -= 1
      queue.enqueue(i)
    })

    if (queue.isEmpty) return Array.fill(n)(0)

    while (queue.nonEmpty) {
      val u = queue.dequeue()
      graph(u).foreach(f = v => {
        degree(v) -= 1
        if (degree(v) == 1) queue.enqueue(v)
      })
    }

    java.util.Arrays.fill(res, Integer.MAX_VALUE)

    (0 until n).foreach(i => if (degree(i) == 2) {
      queue.enqueue(i)
      res(i) = 0
    })

    while (queue.nonEmpty) {
      val u = queue.dequeue()
      graph(u).foreach(v => {
        if (res(v) == Integer.MAX_VALUE) queue.enqueue(v)
        res(v) = res(v).min(res(u) + 1)
      })
    }

    res
  }
}
