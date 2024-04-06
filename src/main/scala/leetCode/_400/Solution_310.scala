package leetCode._400

object Solution_310 {
  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
    if (n == 1) List(0)
    else if (edges.length == 1) edges.head.toList
    else {
      val map = edges
        .toSeq
        .flatMap(edge => Seq(edge, edge.reverse))
        .groupBy(_.apply(0))
        .mapValues(_.map(_.apply(1)).toSeq)

      def increasePath(path: Seq[Int]): Seq[Seq[Int]] = {
        val h1 = path.head
        val h2 = path.tail.head
        val h0s = map(h1).filterNot(_ == h2)
        h0s.map(_ +: path)
      }

      @scala.annotation.tailrec
      def longestPathsImpl(acc: Seq[Seq[Int]]): Seq[Seq[Int]] = {
        val newAcc = acc.flatMap(increasePath)
        if (newAcc.isEmpty) acc
        else longestPathsImpl(newAcc)
      }

      def longestPaths(node: Int): Seq[Seq[Int]] = {
        lazy val paths = map(node).map(Seq(_, node))
        longestPathsImpl(paths)
      }

      lazy val start = map.keys.head
      lazy val endPoints = longestPaths(start).map(_.head)
      lazy val diameters = endPoints.map(longestPaths).maxBy(_.size)

      (if ((diameters.head.size & 1) == 0) diameters.flatMap(d => d.slice((d.size >> 1) - 1, (d.size >> 1) - 1 + 2))
      else diameters.flatMap(d => d.slice(d.size >> 1, d.size >> 1 + 1))).toSet.toList
    }
  }
}
