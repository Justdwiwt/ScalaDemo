package leetCode._500

object Solution_431 {
  class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = Nil
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  class Codec {
    def encode(root: Node): TreeNode = {
      if (root == null) return null
      val newRoot = new TreeNode(root.value)
      val children = root.children
      var cur: TreeNode = null
      if (children.nonEmpty) {
        newRoot.left = encode(children.head)
        cur = newRoot.left
      }
      children.indices.drop(1).foreach(i => {
        cur.right = encode(children(i))
        cur = cur.right
      })
      newRoot
    }

    def decode(root: TreeNode): Node = {
      if (root == null) return null
      val newNode = new Node(root.value)
      var cur = root.left
      while (cur != null) {
        newNode.children :+= decode(cur)
        cur = cur.right
      }
      newNode
    }
  }
}
