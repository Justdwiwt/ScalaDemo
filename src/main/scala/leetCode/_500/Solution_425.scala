package leetCode._500

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution_425 {
  def wordSquares(words: Array[String]): List[List[String]] = {
    val n = words.head.length
    val map = mutable.Map.empty[String, ListBuffer[String]]

    words.foreach(word => words.head.indices.foreach(i => {
      val prefix = word.substring(0, i)
      if (!map.contains(prefix)) map(prefix) = ListBuffer.empty[String]
      map(prefix) += word
    }))
    val list = ListBuffer.empty[String]
    val lists = ListBuffer.empty[List[String]]
    dfs(map, n, list, lists)
    lists.toList
  }

  private def dfs(map: mutable.Map[String, ListBuffer[String]], n: Int, list: ListBuffer[String], lists: ListBuffer[List[String]]): Unit = {
    if (list.size == n) {
      lists += list.toList
      return
    }
    val m = list.length
    val chars: Array[Char] = new Array[Char](m)
    list.indices.foreach(i => chars(i) = list(i).charAt(m))
    val prefix: String = chars.mkString
    if (!map.contains(prefix)) return
    val words = map(prefix)
    words.foreach(word => {
      list += word
      dfs(map, n, list, lists)
      list.trimEnd(1)
    })
  }
}
