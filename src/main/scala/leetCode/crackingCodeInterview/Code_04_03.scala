package leetCode.crackingCodeInterview

import leetCode.{ListNode, TreeNode}

object Code_04_03 {
  def listOfDepth(tree: TreeNode): Array[ListNode] = {
    if (tree == null) return Array[ListNode]()
    listOfDepth(List(tree)).toArray
  }

  private def listOfDepth(_listTreeNode: List[TreeNode]): List[ListNode] = {
    if (_listTreeNode.isEmpty) return Nil
    val recList: List[TreeNode] = _listTreeNode.flatMap(node => {
      var rsList: Vector[TreeNode] = Vector()
      if (node.left != null) rsList = rsList :+ node.left
      if (node.right != null) rsList = rsList :+ node.right
      rsList
    })
    val headListNode: ListNode = new ListNode()
    _listTreeNode.foldLeft(headListNode)((listNodePre, nodeNext) => {
      val listNodeNext = new ListNode(nodeNext.value)
      listNodePre.next = listNodeNext
      listNodeNext
    })
    headListNode.next +: listOfDepth(recList)
  }
}
