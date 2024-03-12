package leetCode._500

import leetCode.TreeNode

import scala.collection.mutable.Stack

object Solution_449 {

  class Codec {
    def serialize(root: TreeNode): String = {
      def serializeHelper(root: TreeNode, sb: StringBuilder): Unit = {
        if (root == null) return
        sb.append(s"${root.value},")
        serializeHelper(root.left, sb)
        serializeHelper(root.right, sb)
      }

      val sb = new StringBuilder()
      serializeHelper(root, sb)
      sb.toString()
    }

    def deserialize(s: String): TreeNode = {
      if (s.isEmpty) return null
      val str = s.split(",")
      val st = new Stack[TreeNode]()
      val root = new TreeNode(str(0).toInt)
      st.push(root)
      var idx = 1
      while (idx < str.size) {
        val newNode = new TreeNode(str(idx).toInt)
        idx += 1
        if (newNode.value < st.top.value) st.top.left = newNode
        else {
          var lastNode: TreeNode = null
          while (st.nonEmpty && newNode.value > st.top.value) {
            lastNode = st.top
            st.pop
          }
          lastNode.right = newNode
        }
        st.push(newNode)
      }
      root
    }
  }

}
