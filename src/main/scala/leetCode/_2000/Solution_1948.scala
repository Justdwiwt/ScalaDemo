package leetCode._2000

import scala.collection.mutable

object Solution_1948 {
  class TrieNode {
    val children: mutable.Map[String, TrieNode] = mutable.TreeMap()
    var deleted: Boolean = false
  }

  def deleteDuplicateFolder(paths: List[List[String]]): List[List[String]] = {
    val root = new TrieNode()
    paths.foreach(path => {
      var curr = root
      path.foreach(folder => {
        if (!curr.children.contains(folder)) curr.children(folder) = new TrieNode()
        curr = curr.children(folder)
      })
    })
    delete(root, mutable.Map[String, TrieNode]())
    val ans = mutable.ArrayBuffer[List[String]]()
    dfs(root, mutable.ArrayBuffer[String](), ans)
    ans.toList
  }

  private def delete(root: TrieNode, map: mutable.Map[String, TrieNode]): String = {
    if (root.children.isEmpty) return ""
    val sb = new StringBuilder
    root.children.foreach { case (folder, child) => sb.append('(').append(folder).append(delete(child, map)).append(')') }
    val serialized = sb.toString()
    if (map.contains(serialized)) {
      map(serialized).deleted = true
      root.deleted = true
    } else map(serialized) = root
    serialized
  }

  private def dfs(root: TrieNode, path: mutable.ArrayBuffer[String], ans: mutable.ArrayBuffer[List[String]]): Unit = {
    root.children.foreach { case (folder, child) =>
      if (!child.deleted) {
        path.append(folder)
        dfs(child, path, ans)
        path.remove(path.size - 1)
      }
    }
    if (path.nonEmpty) ans.append(path.toList)
  }
}
