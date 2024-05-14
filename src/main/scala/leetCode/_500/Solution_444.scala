package leetCode._500

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_444 {
  def sequenceReconstruction(org: Array[Int], seq: List[List[Int]]): Boolean = {
    val n = org.length
    if (n == 0 || seq.isEmpty) false
    else {
      val numSet = new mutable.HashSet[Int]
      var isValid = true

      seq.foreach(_.withFilter(_ => isValid).foreach(num => if (num <= 0 || num > n) isValid = false else numSet.add(num)))

      if (!isValid || numSet.size < n) false
      else {
        val adj = Array.fill(n + 1)(new ArrayBuffer[Int]())

        seq.foreach(pair => pair.indices.dropRight(1).foreach(j => adj(pair(j)).append(pair(j + 1))))

        val inDegree = Array.fill(n + 1)(0)

        (1 to n).foreach(adj(_).foreach(inDegree(_) += 1))

        val queue = mutable.Queue.empty[Int]
        (1 to n).foreach(i => if (inDegree(i) == 0) queue.enqueue(i))

        if (queue.size != 1) false
        else {
          var index = 0
          var allVisited = true
          while (queue.nonEmpty && allVisited) {
            val num = queue.dequeue()
            if (org(index) != num) allVisited = false
            index += 1
            var nextZeroInDegreeCount = 0
            var w = 0
            while (w < adj(num).length && allVisited) {
              inDegree(adj(num)(w)) -= 1
              if (inDegree(adj(num)(w)) == 0) {
                nextZeroInDegreeCount += 1
                if (nextZeroInDegreeCount > 1) allVisited = false
                queue.enqueue(adj(num)(w))
              }
              w += 1
            }
          }
          allVisited && index == n
        }
      }
    }
  }
}
