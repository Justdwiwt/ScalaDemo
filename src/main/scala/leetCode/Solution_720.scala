package leetCode

import scala.collection.mutable

object Solution_720 {
  def longestWord(words: Array[String]): String = {
    var res = ""
    val s = new mutable.HashSet[String]()
    val t = words.sorted
    t.foreach(word => {
      if (word.length == 1 || s.contains(word.substring(0, word.length - 1))) {
        res = if (word.length > res.length) word else res
        s.add(word)
      }
    })
    res
  }
}
