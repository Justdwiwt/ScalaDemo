package leetCode._1000

import leetCode.TreeNode

import java.util
import java.util.Collections

object Solution_988 {

  def smallestFromLeaf(root: TreeNode): String = {
    val list = new util.ArrayList[String]
    dfs(root, new StringBuilder, list)
    Collections.sort(list)
    if (list.isEmpty) null
    else list.get(0)
  }

  def dfs(root: TreeNode, builder: StringBuilder, list: util.ArrayList[String]): Unit = {
    if (null == root) return
    builder.append((root.value + 97).asInstanceOf[Char])
    if (null == root.left && null == root.right) {
      var t = new StringBuilder
      t = builder
      list.add(t.reverse.toString)
    }
    else {
      dfs(root.left, builder, list)
      dfs(root.right, builder, list)
    }
    builder.deleteCharAt(builder.length - 1)
  }

}
