package leetCode

import scala.collection.mutable

object Solution_207 {
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val arr = Array.fill(numCourses)(0)
    val m = mutable.HashMap.empty[Int, List[Int]]
    prerequisites.foreach(idx => {
      val l = m.getOrElse(idx.last, List.empty[Int])
      m += idx.last -> (l :+ idx.head)
      arr(idx.head) = arr(idx.head) + 1
    })
    val q = mutable.Queue.empty[Int]
    var cnt = 0
    arr.zipWithIndex.foreach {
      case (e, i) if e == 0 => q += i
      case _ => ()
    }
    while (q.nonEmpty) {
      val cur = q.dequeue()
      if (arr(cur) == 0) cnt += 1
      m.get(cur).foreach(_.foreach(idx => {
        arr(idx) = arr(idx) - 1
        if (arr(idx) == 0) q += idx
      }))
    }
    cnt == numCourses
  }
}
