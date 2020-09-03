package leetCode

object Solution_1145 {
  def btreeGameWinningMove(root: TreeNode, n: Int, x: Int): Boolean = {
    List(find(root, x)).flatMap({ x: TreeNode => List(n - cnt(x), cnt(x.left), cnt(x.right)) }).exists(_ > n / 2)
  }

  def cnt(root: TreeNode): Int = root match {
    case null => 0
    case _ => cnt(root.left) + cnt(root.right) + 1
  }

  def find(root: TreeNode, x: Int): TreeNode = root match {
    case null => null
    case _ if root.value == x => root
    case _ => find(root.left, x) match {
      case null => find(root.right, x)
      case node => node
    }
  }
}
