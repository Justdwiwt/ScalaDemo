package leetCode._3400

import scala.collection.mutable

object Solution_3313 {
  def lastMarkedNodes(edges: Array[Array[Int]]): Array[Int] = {
    val n = edges.length + 1
    var (mxd, p1, p2) = (0, -1, -1)
    val table = Array.fill(n)(mutable.Set[Int]())

    edges
      .withFilter { case Array(_, _) => true; case _ => false }
      .foreach { case Array(x, y) =>
        table(x).add(y)
        table(y).add(x)
      }

    def dfs(node: Int, parent: Int): (Int, Int) = {
      var curMXd = (0, node, -1, -1)
      table(node)
        .withFilter(_ != parent)
        .foreach(child => {
          val (childMXd, childMXp) = dfs(child, node)
          if (childMXd + 1 >= curMXd._1) curMXd = (childMXd + 1, childMXp, curMXd._1, curMXd._2)
          else if (childMXd + 1 >= curMXd._3) curMXd = (curMXd._1, curMXd._2, childMXd + 1, childMXp)
        })
      if (curMXd._1 + curMXd._3 + 1 > mxd) {
        mxd = curMXd._1 + curMXd._3 + 1
        p1 = curMXd._2
        p2 = curMXd._4
      }
      (curMXd._1, curMXd._2)
    }

    dfs(0, -1)

    val vis1 = mutable.Map[Int, Int]()
    val vis2 = mutable.Map[Int, Int]()

    def bfs(start: Int, vis: mutable.Map[Int, Int]): Unit = {
      val queue = mutable.Queue[Int](start)
      var step = 0
      while (queue.nonEmpty) {
        queue.indices.foreach(_ => {
          val node = queue.dequeue()
          vis(node) = step
          table(node)
            .withFilter(!vis.contains(_))
            .foreach(queue.+=)
        })
        step += 1
      }
    }

    bfs(p1, vis1)
    bfs(p2, vis2)

    Array.tabulate(n)(p => if (vis1.getOrElse(p, 0) > vis2.getOrElse(p, 0)) p1 else p2)
  }
}
