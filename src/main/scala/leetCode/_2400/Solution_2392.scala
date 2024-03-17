package leetCode._2400

object Solution_2392 {
  def buildMatrix(k: Int, rowConditions: Array[Array[Int]], colConditions: Array[Array[Int]]): Array[Array[Int]] = {
    def topSort(edges: Array[Seq[Int]]): Option[Seq[Int]] = {
      val (graph, inDegree) = edges./:(Map.empty[Int, Set[Int]].withDefaultValue(Set.empty), Map.empty[Int, Int].withDefaultValue(0)) {
        case ((graph, inDegree), Seq(before, after)) => (graph.updated(before, graph(before) + after), inDegree.updated(after, inDegree(after) + 1))
      }

      def dfs(toVisit: Seq[Int], inDegree: Map[Int, Int]): Seq[Int] = toVisit.headOption match {
        case None => Seq.empty
        case Some(curr) => curr +: (dfs _).tupled(graph(curr)./:(toVisit.tail, inDegree) {
          case ((toVisit, inDegree), next) =>
            if (inDegree(next) == 1) (toVisit :+ next, inDegree.drop(next))
            else (toVisit, inDegree.updated(next, inDegree(next) - 1))
        })
      }

      Option(dfs(toVisit = (1 to k).filter(inDegree(_) == 0), inDegree)).filter(_.length == k)
    }

    val res = topSort(rowConditions.map(_.toSeq).distinct)
      .flatMap(order1 => topSort(colConditions.map(_.toSeq).distinct).map(order2 => Array.tabulate(k, k) { case (r, c) => if (order1(r) == order2(c)) order1(r) else 0 }))

    res.getOrElse(Array.empty)
  }
}
