package leetCode._700

import scala.collection.mutable

object Solution_685 {
  def findRedundantDirectedConnection(edges: Array[Array[Int]]): Array[Int] = {
    val (graph, parents, child) =
      edges.foldLeft(Array.fill(edges.length)(Option.empty[Int]), Seq.empty[Int], Option.empty[Int]) {
        case ((array, doubles, ch), edge) =>
          val (newParents, newChild) = array(edge.last - 1).map(v => (Seq(v, edge.head), Option(edge.last))).getOrElse((doubles, ch))
          array(edge.last - 1) = Some(edge.head)
          (array, newParents, newChild)
      }

    (parents, child) match {
      case (Seq(a1, a2), Some(c)) =>
        graph(c - 1) = Some(a1)
        if (!isChildOf(a1, c, graph)) Array(a2, c)
        else Array(a1, c)
      case _ =>
        val loop = getLoop(graph)
        val l = (loop :+ loop.head).sliding(2).map(e => e.head -> e.last).toSet
        val idx = edges.lastIndexWhere(e => l.contains((e.last, e.head)))
        edges(idx)
    }
  }

  @scala.annotation.tailrec
  private def isChildOf(c: Int, p: Int, gr: Array[Option[Int]]): Boolean =
    if (c == p) true
    else gr(c - 1) match {
      case Some(m) => isChildOf(m, p, gr)
      case _ => false
    }

  @scala.annotation.tailrec
  private def getLoop(gr: Array[Option[Int]], res: mutable.LinkedHashSet[Int] = new mutable.LinkedHashSet[Int], node: Int = 1): Seq[Int] =
    if (res.contains(node)) res.dropWhile(node.!=).toSeq
    else getLoop(gr, res += node, gr(node - 1).get)
}
