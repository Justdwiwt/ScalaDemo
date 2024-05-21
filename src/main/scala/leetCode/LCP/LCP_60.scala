package leetCode.LCP

import scala.collection.mutable.ArrayBuffer

// fixme: case 155/157 time limit exceeded
object LCP_60 {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  private var curNodes = ArrayBuffer.empty[TreeNode]
  private var nextNodes = ArrayBuffer.empty[TreeNode]

  def getMaxLayerSum(root: TreeNode): Int = {
    var res = root.value
    curNodes += root
    val groups = ArrayBuffer.empty[ArrayBuffer[TreeNode]]

    while (curNodes.nonEmpty) {
      var sumThisLayer = 0
      val countThisLayer = curNodes.size

      while (curNodes.nonEmpty) {
        val node = curNodes.remove(curNodes.size - 1)
        sumThisLayer += node.value
        var nodeCount = 0
        if (node.left != null) {
          nodeCount += 1
          nextNodes += node.left
        }
        if (node.right != null) {
          nodeCount += 1
          nextNodes += node.right
        }

        if (nodeCount <= 1) {
          val newGroup = ArrayBuffer.empty[TreeNode]
          newGroup += node
          groups += newGroup
        }
      }

      var maxIncrease = 0
      groups.indices.foreach(i => {
        val group = groups(i)
        val groupNodeCount = group.size
        var oldSum = 0
        var newSum = 0

        group.indices.foreach(_ => {
          val node = group.remove(0)
          oldSum += node.value

          if (node.left != null) {
            newSum += node.left.value
            group += node.left
          }
          if (node.right != null) {
            newSum += node.right.value
            group += node.right
          }
        })

        if (countThisLayer != groupNodeCount) {
          if (group.nonEmpty) groups(i) = group
          maxIncrease = maxIncrease.max(newSum - oldSum)
        }
      })

      res = res.max(sumThisLayer + maxIncrease)

      val tmp = curNodes
      curNodes = nextNodes
      nextNodes = tmp
      nextNodes.clear()
    }
    res
  }
}
