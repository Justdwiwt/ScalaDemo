package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_890 {
  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
    var res = List[String]()
    words.foreach(str => {
      val w2p = new mutable.HashMap[Char, Char]()
      val p2w = new mutable.HashMap[Char, Char]()
      var i = 0
      val n = str.length
      breakable {
        while (i < n) {
          if (w2p.contains(str(i)) && w2p(str(i)) != pattern(i)) break
          w2p(str(i)) = pattern(i)
          if (p2w.contains(pattern(i)) && p2w(pattern(i)) != str(i)) break
          p2w(pattern(i)) = str(i)
          i += 1
        }
      }
      if (i == n) res :+= str
    })
    res
  }
}
