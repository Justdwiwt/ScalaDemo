package leetCode

import java.util

object Solution_2476 {
  private var tree = new util.TreeSet[Integer]()

  def closestNodes(root: TreeNode, queries: List[Int]): List[List[Int]] = {
    tree = new util.TreeSet[Integer]()
    dfs(root)
    var res = List.empty[List[Int]]
    queries.foreach(x => {
      val a = tree.floor(x)
      val b = tree.ceiling(x)
      var t = List.empty[Int]
      t ::= (if (a == null) -1 else a)
      t = t.reverse
      t ::= (if (b == null) -1 else b)
      t = t.reverse
      res ::= t
    })
    res.reverse
  }

  private def dfs(node: TreeNode): Unit = {
    if (node == null) return
    dfs(node.left)
    tree.add(node.value)
    dfs(node.right)
  }
}
