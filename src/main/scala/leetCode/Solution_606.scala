package leetCode

object Solution_606 {
  def tree2str(t: TreeNode): String = {
    val trim = "(\\(\\))+$".r

    def f(root: TreeNode): String = root match {
      case null => "()"
      case r =>
        val lt = trim.replaceFirstIn(f(r.left), "")
        val rt = trim.replaceFirstIn(f(r.right), "")
        r.value.toString + "(" + lt + ")(" + rt + ")"
    }

    trim.replaceFirstIn(f(t), "")
  }
}
