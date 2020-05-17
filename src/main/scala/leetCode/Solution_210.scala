package leetCode

import scala.collection.mutable

object Solution_210 {
  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = numCourses match {
    case 0 => Array.empty
    case _ =>
      val inDegrees = Array.fill(numCourses)(0)
      prerequisites.foreach(i => inDegrees(i(0)) += 1)
      val q = new mutable.Queue[Int]()
      inDegrees.indices.foreach(i => if (inDegrees(i) == 0) q.enqueue(i))
      var cnt = 0
      val res = Array.fill(numCourses)(0)
      while (q.nonEmpty) {
        val cur = q.dequeue()
        res(cnt) = cur
        cnt += 1
        prerequisites.foreach(i => {
          if (i(1) == cur) {
            inDegrees(i(0)) -= 1
            if (inDegrees(i(0)) == 0) q.enqueue(i(0))
          }
        })
      }
      if (cnt == numCourses) return res
      Array.empty
  }
}
