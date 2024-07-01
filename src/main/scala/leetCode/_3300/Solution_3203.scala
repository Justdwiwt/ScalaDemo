package leetCode._3300

import scala.collection.mutable

object Solution_3203 {
  def minimumDiameterAfterMerge(edges1: Array[Array[Int]], edges2: Array[Array[Int]]): Int = {
    val diameter1 = treeDiameter(edges1)
    val diameter2 = treeDiameter(edges2)
    val semiDiameter1 = (diameter1 + 1) / 2
    val semiDiameter2 = (diameter2 + 1) / 2
    diameter1.max(diameter2).max(semiDiameter1 + semiDiameter2 + 1)
  }

  private def treeDiameter(edges: Array[Array[Int]]): Int = {
    val n = edges.length + 1
    val adjacentArr = Array.fill[List[Int]](n)(List.empty[Int])

    edges.foreach(edge => {
      val a = edge.head
      val b = edge(1)
      adjacentArr(a) ::= b
      adjacentArr(b) ::= a
    })

    val degrees = Array.ofDim[Int](n)
    val queue = mutable.Queue[Int]()

    (0 until n).foreach(i => {
      degrees(i) = adjacentArr(i).length
      if (degrees(i) == 1) queue.enqueue(i)
    })

    var levels = 0
    var remain = n

    while (remain > 2) {
      levels += 1
      val size = queue.size

      (0 until size).foreach(_ => {
        val node = queue.dequeue()
        val adjacent = adjacentArr(node)

        adjacent.foreach(next => if (degrees(next) == 1) ()
        else {
          degrees(next) -= 1
          if (degrees(next) == 1) queue.enqueue(next)
        })
      })

      remain -= size
    }

    levels * 2 + remain - 1
  }
}
