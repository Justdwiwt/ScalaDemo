package leetCode._2300

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_2277 {
  def closestNode(n: Int, edges: Array[Array[Int]], query: Array[Array[Int]]): Array[Int] = {
    val G = Array.fill[ListBuffer[Int]](n)(ListBuffer[Int]())
    edges.foreach(edge => {
      val a = edge.head
      val b = edge(1)
      G(a).append(b)
      G(b).append(a)
    })

    val D = Array.ofDim[Int](n, n)
    (0 until n).foreach(a => {
      val dist = Array.fill(n)(Int.MaxValue)
      val que = mutable.Queue[Int]()
      que.enqueue(a)
      dist(a) = 0
      while (que.nonEmpty) {
        val q = que.dequeue()
        G(q).foreach(b => if (dist(b) == Int.MaxValue) {
          dist(b) = dist(q) + 1
          que.enqueue(b)
        })
      }
      (0 until n).foreach(i => D(a)(i) = dist(i))
    })

    query.map { case Array(a, b, q) => (0 until n).minBy(x => D(x)(a) + D(x)(b) + D(x)(q)) }
  }
}
