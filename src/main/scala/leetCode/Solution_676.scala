package leetCode

import scala.collection.mutable

object Solution_676 {

  class MagicDictionary() {
    private val m = mutable.Map[Int, mutable.Set[String]]()

    def buildDict(dict: Array[String]) {
      dict.foreach(i => {
        val len = i.length
        if (m.contains(len)) m(len).add(i)
        else m += len -> mutable.Set[String](i)
      })
    }

    def search(word: String): Boolean = {
      if (!m.contains(word.length)) return false
      m(word.length).foreach(i => {
        var diff = 0
        word.indices.foreach(j => if (i(j) != word(j)) diff += 1)
        if (diff == 1) return true
      })
      false
    }
  }

}
