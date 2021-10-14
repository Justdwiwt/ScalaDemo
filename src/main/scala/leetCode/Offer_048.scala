package leetCode

object Offer_048 {
  class Codec {
    def serialize(root: TreeNode): String = {
      val out = new StringBuilder()

      def dfs(node: TreeNode): Unit =
        if (null == node) out ++= "null"
        else {
          out ++= node.value.toString
          out += ','
          dfs(node.left)
          out += ','
          dfs(node.right)
        }

      dfs(root)
      out.result
    }

    def deserialize(data: String): TreeNode = {
      var tokens = data.split(',').toList

      def build(): TreeNode = tokens match {
        case Nil => null
        case "null" :: tail =>
          tokens = tail
          null
        case head :: tail =>
          val node = new TreeNode(head.toInt)
          tokens = tail
          node.left = build()
          node.right = build()
          node
      }

      build()
    }
  }
}
