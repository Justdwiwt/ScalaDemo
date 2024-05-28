package leetCode._2300

import scala.collection.mutable

object Solution_2246 {
  def longestPath(parent: Array[Int], s: String): Int = {
    var res = 0
    val n = parent.length
    val degree = Array.fill(n)(0)
    val bests = Array.fill(n)(0)
    val queue = mutable.Queue.empty[Int]

    parent.indices.drop(1).foreach(i => degree(parent(i)) += 1)

    parent.indices.foreach(i => if (degree(i) == 0) {
      queue.enqueue(i)
      res = 1
    })

    while (queue.nonEmpty) {
      val index = queue.dequeue()
      val v = bests(index) + 1
      val p = parent(index)

      if (p != -1) {
        degree(p) -= 1
        if (s.charAt(p) != s.charAt(index)) {
          res = res.max(bests(p) + v + 1)
          bests(p) = v.max(bests(p))
        }

        if (degree(p) == 0) queue.enqueue(p)
      }
    }

    res
  }
}
