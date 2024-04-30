package leetCode._1500

object Solution_1485 {
  class Node(var _value: Int, _left: Node = null, _right: Node = null, _random: Node = null) {
    var value: Int = _value
    var left: Node = _left
    var right: Node = _right
    var random: Node = _random
  }

  def copyRandomBinaryTree(root: Node): NodeCopy = {
    if (root == null) return null
    val seen = scala.collection.mutable.Map[Node, NodeCopy]()

    def dfs(node: Node): NodeCopy = {
      if (seen.contains(node)) return seen(node)
      val newNode = NodeCopy(node.value)
      seen(node) = newNode
      if (node.left != null) newNode.left = dfs(node.left)
      if (node.right != null) newNode.right = dfs(node.right)
      if (node.random != null) newNode.random = dfs(node.random)
      newNode
    }

    dfs(root)
  }

  case class NodeCopy(var value: Int, var left: NodeCopy = null, var right: NodeCopy = null, var random: NodeCopy = null)
}
