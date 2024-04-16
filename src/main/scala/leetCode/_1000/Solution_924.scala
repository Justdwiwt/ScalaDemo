package leetCode._1000

object Solution_924 {

  private case class Node(res: Int, size: Int, vis: Set[Int])

  def minMalwareSpread(graph: Array[Array[Int]], initial: Array[Int]): Int =
    initial.sorted./:(Node(0, -1, Set.empty[Int]))(g(graph.map(_.zipWithIndex.filter(_._1 == 1).map(_._2)), initial.toSet)).res

  private def g(graph: Array[Array[Int]], initial: Set[Int])(d: Node, n: Int): Node = {
    val segInfo = f(graph, Set(n), d.vis ++ (initial - n), Set.empty[Int])
    if (segInfo._1 > d.size) Node(n, segInfo._1, d.vis ++ segInfo._2)
    else Node(d.res, d.size, d.vis ++ segInfo._2)
  }

  @scala.annotation.tailrec
  private def f(graph: Array[Array[Int]], queue: Set[Int], vis: Set[Int], visSeg: Set[Int]): (Int, Set[Int]) =
    if (queue.isEmpty) (visSeg.size, visSeg)
    else {
      val visSegNew = visSeg ++ queue
      if (queue.intersect(vis).nonEmpty) (0, visSegNew)
      else {
        val newQueue = queue.flatMap(graph(_)) -- visSegNew
        f(graph, newQueue, vis, visSegNew)
      }
    }

}
