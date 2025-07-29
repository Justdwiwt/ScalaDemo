package leetCode._3700

import scala.collection.mutable

object Solution_3607 {
  class DisjointSets[X](xs: Seq[X]) {
    private case class Node(x: X, var parent: Option[Node] = None, var height: Int = 0) {
      def progenitor: Node = parent match {
        case Some(node) => node.progenitor
        case _ => this
      }
    }

    private val elemToNode: Map[X, Node] =
      xs.iterator.map(x => x -> Node(x)).toMap

    def union(x1: X, x2: X): DisjointSets[X] = {
      val node1 = elemToNode(x1).progenitor
      val node2 = elemToNode(x2).progenitor
      if (node1 != node2) {
        if (node1.height >= node2.height) {
          node2.parent = Some(node1)
          node1.height = math.max(node1.height, node2.height + 1)
        } else node1.parent = Some(node2)
      }
      this
    }

    def find(x: X): X =
      elemToNode(x).progenitor.x
  }

  def processQueries(c: Int, connections: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val disjointSets = new DisjointSets(1 to c)
    connections
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(u, v) => disjointSets.union(u, v) }

    val stationToGrid = mutable.Map.empty[Int, mutable.SortedSet[Int]]
    val groups = (1 to c).groupBy(disjointSets.find)

    groups.foreach { case (_, members) =>
      val sortedSet = mutable.SortedSet.empty[Int] ++ members
      members.foreach(stationToGrid(_) = sortedSet)
    }

    val res = mutable.ArrayBuffer.empty[Int]
    queries.foreach(q => if (q.head == 1) {
      val station = q(1)
      if (stationToGrid.contains(station) && stationToGrid(station).contains(station))
        res += station
      else {
        val grid = stationToGrid.getOrElse(station, mutable.SortedSet.empty[Int])
        if (grid.nonEmpty) res += grid.head
        else res += -1
      }
    } else if (q.head == 2) {
      val station = q(1)
      stationToGrid.get(station).foreach(_.remove(station))
    })
    res.toArray
  }
}
