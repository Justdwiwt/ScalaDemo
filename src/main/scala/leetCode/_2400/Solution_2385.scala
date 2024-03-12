package leetCode._2400

import leetCode.TreeNode

import scala.collection.mutable

object Solution_2385 {
  def amountOfTime(root: TreeNode, start: Int): Int = {
    val adjacent = buildAdjacent(root)
    val visited = scala.collection.mutable.Set(start)
    var visit = List(start)
    var minutes = -1
    while (visit.nonEmpty) {
      visit = visit.flatMap(adjacent(_)).filter(visited.add)
      minutes += 1
    }
    minutes
  }

  def buildAdjacent(root: TreeNode): mutable.Map[Int, List[Int]] = {
    val adjacent = scala.collection.mutable.Map.empty[Int, List[Int]].withDefaultValue(List.empty)

    def dfs(parent: TreeNode): Unit = {
      def go(child: TreeNode): Unit =
        if (child != null) {
          adjacent(parent.value) ::= child.value
          adjacent(child.value) ::= parent.value
          dfs(child)
        }

      go(parent.left)
      go(parent.right)
    }

    dfs(root)
    adjacent
  }
}
