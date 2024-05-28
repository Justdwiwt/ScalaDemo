package leetCode._2200

import leetCode.TreeNode

import scala.collection.mutable

object Solution_2196 {
  def createBinaryTree(descriptions: Array[Array[Int]]): TreeNode = {
    val map = mutable.Map.empty[Int, TreeNode]
    val childFlag = Array.fill(100001)(0)

    descriptions.foreach(description => {
      val parentVal = description.head
      val childVal = description(1)
      val isLeft = description(2)

      if (!map.contains(parentVal)) map(parentVal) = new TreeNode(parentVal)

      if (!map.contains(childVal)) map(childVal) = new TreeNode(childVal)

      childFlag(childVal) = 1

      val parent = map(parentVal)
      val child = map(childVal)

      if (isLeft == 1) parent.left = child
      else parent.right = child
    })

    val rootVal = map.keys.find(childFlag(_) == 0).getOrElse(-1)
    map(rootVal)
  }
}
