package leetCode

import scala.collection.mutable

object Solution_889 {
  def constructFromPrePost(pre: Array[Int], post: Array[Int]): TreeNode = {
    val m = new mutable.HashMap[Int, Int]()
    post.indices.foreach(i => m(post(i)) = i)
    func(pre, 0, pre.length - 1, post, 0, post.length - 1, m)
  }

  def func(pre: Array[Int], preL: Int, preR: Int, post: Array[Int], postL: Int, postR: Int, m: mutable.HashMap[Int, Int]): TreeNode = {
    if (preL > preR || postL > postR) return null
    val node = new TreeNode(pre(preL))
    if (preL == preR) return node
    val idx = m(pre(preL + 1))
    val len = (idx - postL) + 1
    node.left = func(pre, preL + 1, preL + len, post, postL, idx, m)
    node.right = func(pre, preL + 1 + len, preR, post, idx + 1, postR - 1, m)
    node
  }
}
