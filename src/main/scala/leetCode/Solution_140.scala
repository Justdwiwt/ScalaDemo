package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_140 {
  private val m = new mutable.HashMap[String, List[String]]()

  def wordBreak(s: String, wordDict: List[String]): List[String] = {
    if (m.contains(s)) return m(s)
    if (s.isEmpty) return List.empty
    var res = List.empty[String]
    wordDict.foreach(word => {
      breakable {
        if (s.substring(0, word.length) != word) break()
      }
      val rem = wordBreak(s.substring(word.length), wordDict)
      rem.foreach(str => res :+= (word + (if (str.isEmpty) "" else " ") + str))
    })
    m(s) = res
    res
  }
}
