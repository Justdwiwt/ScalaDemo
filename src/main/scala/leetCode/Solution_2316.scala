package leetCode

import scala.collection.mutable

object Solution_2316 {
  def countPairs(n: Int, edges: Array[Array[Int]]): Long = {
    val routes = mutable.Map.empty[Int, List[Int]]

    edges.foreach {
      case Array(n1, n2) =>
        routes(n1) = n2 :: routes.getOrElse(n1, List.empty)
        routes(n2) = n1 :: routes.getOrElse(n2, List.empty)
      case _ => ???
    }

    val components = computeComponentSizes(n, routes)

    countPairs(components, 0, 0)
  }

  private def computeComponentSizes(n: Int, routes: mutable.Map[Int, List[Int]]): List[Long] = {
    val visited = Array.fill(n)(false)

    def dfs(i: Int): Int =
      if (visited(i)) 0
      else {
        visited(i) = true
        1 + routes.getOrElse(i, List.empty).map(dfs).sum
      }

    (0 until n)./:(List.empty[Long])((components, i) => if (visited(i)) components else dfs(i) :: components)
  }

  @scala.annotation.tailrec
  private def countPairs(list: List[Long], sum: Long, acc: Long): Long = list match {
    case h :: tail => countPairs(tail, sum + h, acc + h * sum)
    case Nil => acc
  }

}
