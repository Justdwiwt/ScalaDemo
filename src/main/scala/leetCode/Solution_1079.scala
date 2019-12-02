package leetCode

import scala.collection.mutable

object Solution_1079 {
  def numTilePossibilities(tiles: String): Int = {
    val dict = Array.fill(tiles.length)(0)
    tiles.indices.foreach(i => dict(i) = tiles(i))
    dfs("", dict, new mutable.HashSet[String]())
  }

  def dfs(word: String, dict: Array[Int], set: mutable.HashSet[String]): Int = {
    var cnt = 0
    if (word.length != 0 && !set.contains(word)) {
      set.add(word)
      cnt += 1
    }
    dict.indices.foreach(i => {
      val d = dict
      val t = d.drop(i)
      cnt += dfs(word + t, d, set)
    })
    cnt
  }
}
