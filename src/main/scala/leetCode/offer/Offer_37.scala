package leetCode.offer

import leetCode.TreeNode

import scala.collection.mutable

object Offer_37 {

  private var res = ""

  def serialize(root: TreeNode): String = {
    if (root == null) return "[]"
    val q = new mutable.Queue[TreeNode]()
    q.enqueue(root)
    res = "[" + root.value
    while (q.nonEmpty) {
      val t = q.head
      q.dequeue()
      if (t.left != null) {
        q.enqueue(t.left)
        res += "," + t.left.value
      } else res += ",null"
      if (t.right != null) {
        q.enqueue(t.right)
        res += "," + t.right.value
      } else res += ",null"
    }
    res += "]"
    res
  }

  def deserialize(data: String): TreeNode = {
    if (data.length == 2) return null
    val t = data.substring(1, data.length - 1)
    val diff = t.split(",")
    val q = new mutable.Queue[TreeNode]()
    val root = new TreeNode(diff(0).toInt)
    q.enqueue(root)
    var i = 1
    while (q.nonEmpty) {
      val tmp = q.head
      q.dequeue()
      if (diff(i).equals("null")) tmp.left = null
      else {
        tmp.left = new TreeNode(diff(i).toInt)
        q.enqueue(tmp.left)
      }
      i += 1
      if (diff(i).equals("null")) tmp.right = null
      else {
        tmp.right = new TreeNode(diff(i).toInt)
        q.enqueue(tmp.right)
      }
      i += 1
    }
    root
  }
}
