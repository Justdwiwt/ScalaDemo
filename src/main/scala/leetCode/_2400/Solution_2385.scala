package leetCode._2400

import leetCode.TreeNode

object Solution_2385 {
  def amountOfTime(root: TreeNode, start: Int): Int = {
    def getConnections(root: TreeNode): Map[Int, Set[Int]] = {
      @scala.annotation.tailrec
      def g(rem: List[TreeNode], m: Map[Int, Set[Int]]): Map[Int, Set[Int]] = rem match {
        case Nil => m
        case h :: t =>
          val children = List(h.left, h.right).filter(_ != null)
          val m1 = children.map(n => (n.value, Set(n.left, n.right).filter(_ != null).map(_.value) + h.value)).toMap
          g(children ++ t, m ++ m1)
      }

      g(List(root), Map.empty) ++ Map(root.value -> Set(root.left, root.right).filter(_ != null).map(_.value))
    }

    @scala.annotation.tailrec
    def f(current: Set[Int], visited: Set[Int], connections: Map[Int, Set[Int]], acc: Int = 0): Int =
      if (current.isEmpty) acc
      else {
        val currUpd = current.flatMap(connections).filter(!visited.contains(_))
        f(currUpd, visited ++ current, connections, acc + 1)
      }

    val connections = getConnections(root)
    f(connections(start), Set(start), connections)
  }
}
