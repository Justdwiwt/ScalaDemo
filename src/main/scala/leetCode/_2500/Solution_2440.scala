package leetCode._2500

import scala.collection.mutable

object Solution_2440 {
  def componentValue(nums: Array[Int], edges: Array[Array[Int]]): Int = {
    val (sum, n) = (nums.sum, nums.length)
    if (n == 1) return 0
    val graph = mutable.Map.empty[Int, mutable.ListBuffer[Int]]
    val deg = Array.fill(n)(0)
    edges.foreach { case Array(a, b) =>
      graph.getOrElseUpdate(a, mutable.ListBuffer.empty).append(b)
      graph.getOrElseUpdate(b, mutable.ListBuffer.empty).append(a)
      deg(a) += 1
      deg(b) += 1
    }

    def bfs(target: Int): Boolean = {
      val values = Array(nums: _*)
      val degree = Array(deg: _*)
      val toVisit = mutable.Queue(nums.indices.filter(n => degree(n) == 1): _*)
      while (toVisit.nonEmpty) {
        val curr = toVisit.dequeue()
        if (degree(curr) != 0) degree(curr) = 0
        if (values(curr) == target) graph(curr).foreach(next => {
          degree(next) -= 1
          if (degree(next) == 0) return values(next) == target
          else if (degree(next) == 1) toVisit += next
        })
        else graph(curr).foreach(next => {
          if (degree(next) > 0) degree(next) -= 1
          values(next) += values(curr)
          if (degree(next) == 0) return values(next) == target
          else if (degree(next) == 1) toVisit += next
        })
      }
      false
    }

    (1 until sum)
      .collectFirst { case candidate if sum % candidate == 0 && bfs(candidate) => sum / candidate - 1 }
      .getOrElse(0)
  }
}
