package leetCode._1500

import scala.collection.mutable

object Solution_1489 {
  def findCriticalAndPseudoCriticalEdges(n: Int, edges: Array[Array[Int]]): List[List[Int]] = {
    val sorted = edges.indices.sortBy(edges(_)(2))

    def minSpanTreeWeight(forcedEdgeI: Option[Int] = None)(freeEdgeIs: Seq[Int] = sorted): Option[Int] = {
      val pq = mutable.PriorityQueue(freeEdgeIs: _*)(Ordering.by(-edges(_)(2)))
      val st = mutable.Set((0 until n).map(Set(_)): _*)
      var weight = 0

      def join(edgeI: Int): Unit = {
        val Array(a, b, w) = edges(edgeI)

        val c0 = st.find(_.contains(a)).get
        val c1 = st.find(_.contains(b)).get

        if (c0.ne(c1)) {
          st.remove(c0)
          st.remove(c1)
          st.add(c0 ++ c1)
          weight += w
        }
      }

      forcedEdgeI.foreach(join)
      while (pq.nonEmpty && st.size > 1) join(pq.dequeue())
      if (st.size == 1) Option(weight) else Option(-1)
    }

    val minWeight = minSpanTreeWeight()().get

    val criticalIs = edges.indices.filter(edgeI => {
      val t = minSpanTreeWeight()(sorted.diff(Seq(edgeI)))
      !t.contains(minWeight)
    })

    val pseudoIs = edges.indices.filterNot(criticalIs.contains).filter(edgeI => {
      val t = minSpanTreeWeight(Some(edgeI))(sorted.diff(Seq(edgeI)))
      t.contains(minWeight)
    })

    List(criticalIs.toList, pseudoIs.toList)
  }
}
