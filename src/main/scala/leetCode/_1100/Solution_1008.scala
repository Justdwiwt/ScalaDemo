package leetCode._1100

import leetCode.TreeNode

object Solution_1008 {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    val res = new TreeNode(preorder(0))
    preorder.tail./:(List(res))((n, v) => {
      val cur = new TreeNode(v)
      val (smaller, larger) = n.span(_.value < v)
      smaller match {
        case Nil => larger.head.left = cur
        case _ => smaller.last.right = cur
      }
      cur :: larger
    })
    res
  }
}
