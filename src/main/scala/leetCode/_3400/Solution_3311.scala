package leetCode._3400

object Solution_3311 {
  def constructGridLayout(n: Int, edges: Array[Array[Int]]): Array[Array[Int]] = {
    val graph = buildGraph(n, edges)
    val degree = (0 until n)
      .map(_ -> 0)
      .toMap ++ edges
      .flatMap { case Array(u, v) => Seq(u -> 1, v -> 1) }
      .groupBy(_._1)
      .mapValues(_.map(_._2).sum)

    val (startNode, _) = degree.minBy(_._2)

    val directions = Array((0, 1), (1, 0))
    val queue = scala.collection.mutable.Queue(startNode)
    var visited = Map(startNode -> (0, 0))
    var (rows, cols) = (1, 1)

    while (queue.nonEmpty) {
      val currentNode = queue.dequeue()
      if (currentNode == startNode) {
        graph(currentNode).zip(directions).foreach { case (neighbor, (dx, dy)) =>
          queue += neighbor
          visited += (neighbor -> (dx, dy))
          rows = rows.max(dx + 1)
          cols = cols.max(dy + 1)
        }
      } else {
        graph(currentNode).filterNot(visited.contains).foreach { neighbor =>
          queue += neighbor
          val (maxRow, maxCol, connectedCount) = graph(neighbor).filter(visited.contains).foldLeft((-1, -1, 0)) {
            case ((maxRow, maxCol, count), adjacent) =>
              val (row, col) = visited(adjacent)
              (maxRow.max(row), maxCol.max(col), count + 1)
          }

          val position = if (connectedCount == 1) {
            if (maxRow == 0) (maxRow, maxCol + 1) else (maxRow + 1, maxCol)
          } else (maxRow, maxCol)

          visited += (neighbor -> position)
          rows = rows.max(position._1 + 1)
          cols = cols.max(position._2 + 1)
        }
      }
    }

    val res = Array.fill(rows, cols)(-1)
    visited.foreach { case (node, (row, col)) => res(row)(col) = node }
    res
  }

  private def buildGraph(n: Int, edges: Array[Array[Int]]): Map[Int, Set[Int]] = edges
    .foldLeft((0 until n).map(_ -> Set.empty[Int]).toMap) {
      case (graph, Array(u, v)) => graph + (u -> (graph(u) + v)) + (v -> (graph(v) + u))
    }
}
