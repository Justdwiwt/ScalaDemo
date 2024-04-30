package leetCode._1300

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_1245 {
  def treeDiameter(edges: Array[Array[Int]]): Int = {
    val N = edges.length
    val graph = Array.fill(N + 1)(ArrayBuffer.empty[Int])
    val inDegree = Array.ofDim[Int](N + 1)

    (0 to N).foreach(graph(_) = ArrayBuffer.empty[Int])

    edges.foreach(edge => {
      graph(edge(0)).append(edge(1))
      graph(edge(1)).append(edge(0))
      inDegree(edge(0)) += 1
      inDegree(edge(1)) += 1
    })

    val q = mutable.Queue.empty[Int]
    val tempQ = mutable.Queue.empty[Int]
    var count = N + 1
    var level = 0

    (0 to N).foreach(i => if (inDegree(i) == 1) q.enqueue(i))

    while (count > 2) {
      count -= q.size
      while (q.nonEmpty) {
        val node = q.dequeue()
        graph(node).foreach(child => {
          inDegree(child) -= 1
          if (inDegree(child) == 1) tempQ.enqueue(child)
        })
      }
      level += 1
      q.clear()
      q ++= tempQ
      tempQ.clear()
    }

    if (count == 1) level * 2 else level * 2 + 1
  }
}
