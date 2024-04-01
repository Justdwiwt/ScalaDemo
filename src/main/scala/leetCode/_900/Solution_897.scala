package leetCode._900

object Solution_897 {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def increasingBST(root: TreeNode): TreeNode = {
    def flatten(root: TreeNode): Seq[Int] =
      if (root == null) Nil
      else flatten(root.left) ++ (root.value +: flatten(root.right))

    def impl(seq: Seq[Int]): TreeNode =
      if (seq.isEmpty) null
      else new TreeNode(seq.head, null, impl(seq.tail))

    impl(flatten(root))
  }
}
