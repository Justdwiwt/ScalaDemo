package leetCode

object LCP_26 {
  def navigation(root: TreeNode): Int = {
    val DEMAND_NOPROVIDE = 1
    val NODEMAND_NOPROVIDE = 2
    val DEMAND_PROVIDE = 4
    val NODEMAND_PROVIDE = 8
    val NODEMAND_PROVIDE2 = 16

    var res = 0
    if (root == null) return 0

    def dfs(node: TreeNode): Int = {
      if (node.left == null && node.right == null) return DEMAND_NOPROVIDE
      if (node.left != null && node.right != null) {
        val l = dfs(node.left)
        val r = dfs(node.right)
        l | r match {
          case DEMAND_NOPROVIDE =>
            res += 1
            return NODEMAND_PROVIDE
          case NODEMAND_PROVIDE | DEMAND_NOPROVIDE => return DEMAND_PROVIDE
          case DEMAND_PROVIDE | DEMAND_NOPROVIDE => return DEMAND_PROVIDE
          case NODEMAND_PROVIDE2 | DEMAND_NOPROVIDE => return NODEMAND_PROVIDE
          case DEMAND_PROVIDE | NODEMAND_PROVIDE => return NODEMAND_PROVIDE2
          case DEMAND_PROVIDE => return NODEMAND_PROVIDE2
          case NODEMAND_PROVIDE => return NODEMAND_PROVIDE2
          case NODEMAND_PROVIDE2 | DEMAND_PROVIDE => return NODEMAND_PROVIDE2
          case NODEMAND_PROVIDE2 | NODEMAND_PROVIDE => return NODEMAND_PROVIDE2
          case NODEMAND_PROVIDE2 => return NODEMAND_PROVIDE2
          case _ =>
        }
      }
      val s = if (node.left == null) dfs(node.right) else dfs(node.left)
      s match {
        case DEMAND_NOPROVIDE => return DEMAND_NOPROVIDE
        case NODEMAND_PROVIDE => return DEMAND_PROVIDE
        case DEMAND_PROVIDE => return DEMAND_PROVIDE
        case NODEMAND_PROVIDE2 => return NODEMAND_PROVIDE2
        case _ =>
      }
      NODEMAND_NOPROVIDE
    }

    val s = dfs(root)
    if (s != NODEMAND_NOPROVIDE && s != NODEMAND_PROVIDE2) return res + 1

    res
  }
}
