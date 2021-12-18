package leetCode

import scala.collection.mutable

object LCP_44 {
  def numColor(root: TreeNode): Int = {
    val st = mutable.HashSet.empty[Int]

    def dfs(root: TreeNode): Unit = {
      if (root == null) return
      st += root.value
      dfs(root.left)
      dfs(root.right)
    }

    dfs(root)

    st.size
  }
}
