package leetCode._1900

import scala.collection.mutable

object Solution_1882 {
  def assignTasks(servers: Array[Int], tasks: Array[Int]): Array[Int] = {
    val res = Array.fill(tasks.length)(0)
    val pq = mutable.PriorityQueue.empty[(Int, Int)].reverse
    pq ++= servers.indices.view.map(si => servers(si) -> si)
    val busy = mutable.PriorityQueue.empty[(Long, Int)].reverse
    var time = 0L
    tasks.indices.foreach(task => {
      time = time.max(task)
      if (pq.isEmpty) time = time.max(busy.head._1)
      while (busy.nonEmpty && busy.head._1 == time) {
        val si = busy.dequeue()._2
        pq += ((servers(si), si))
      }
      val si = pq.dequeue()._2
      busy += ((time + tasks(task), si))
      res(task) = si
    })
    res
  }
}
