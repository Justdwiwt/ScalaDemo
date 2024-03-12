package leetCode._1100

import leetCode.TreeNode

object Solution_1028 {
  def recoverFromPreorder(S: String): TreeNode = {
    f(S.toList, 0)._1
  }

  def f(s: List[Char], level: Int): (TreeNode, List[Char]) = {
    if (s.isEmpty) return (null, s)
    val (depth, rest) = s.span(_ == '-') match {
      case (d, r) => (d.length, r)
    }
    if (depth != level) return (null, s)
    val (num, restStr) = rest.span(_ != '-') match {
      case (n, ns) => (n./:("")((x, y) => x + y).toInt, ns)
    }
    val node = new TreeNode(num)
    val c = f(restStr, level + 1)
    node.left = c._1
    val c2 = f(c._2, level + 1)
    node.right = c2._1
    (node, c2._2)
  }
}
