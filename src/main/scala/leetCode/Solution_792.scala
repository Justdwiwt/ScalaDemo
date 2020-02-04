package leetCode

import scala.collection.mutable
import scala.util.control.Breaks._

object Solution_792 {
  def numMatchingSubseq(S: String, words: Array[String]): Int = {
    if (S.isEmpty) return 0
    val pass = new mutable.HashSet[String]()
    val fail = new mutable.HashSet[String]()
    var res = 0
    words.foreach(word => {
      breakable {
        if (pass.contains(word) || fail.contains(word)) {
          if (pass.contains(word)) res += 1
          break()
        }
      }
      var i = 0
      var j = 0
      while (i < S.length && j < word.length) {
        if (S(i) == word(j)) j += 1
        i += 1
      }
      if (j == word.length) {
        res += 1
        pass.add(word)
      } else fail.add(word)
    })
    res
  }
}
