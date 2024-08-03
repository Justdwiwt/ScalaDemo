package leetCode._2200

import scala.collection.mutable

class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution_2196 {
  def createBinaryTree(descriptions: Array[Array[Int]]): TreeNode = {
    val children = mutable.Map.empty[Int, Boolean]
    val nodes = mutable.Map.empty[Int, TreeNode]

    descriptions.foreach(description => {
      val parent = description.head
      val child = description(1)
      val isLeft = description(2)

      val parentNode = nodes.getOrElseUpdate(parent, new TreeNode(parent))
      val childNode = nodes.getOrElseUpdate(child, new TreeNode(child))

      if (isLeft == 1) parentNode.left = childNode
      else parentNode.right = childNode

      children.get(parent) match {
        case Some(_) =>
        case None => children.update(parent, false)
      }

      children.update(child, true)
    })

    val rootIndex = children.find(!_._2).get

    nodes.getOrElse(rootIndex._1, null)
  }
}
