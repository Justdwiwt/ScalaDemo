package leetCode._300

import scala.collection.mutable

object Solution_288 {

  class ValidWordAbbr(dictionary: Array[String]) {
    private val dict = mutable.HashSet(dictionary: _*)
    private val abbrDict: mutable.HashMap[String, Boolean] = {
      val map = mutable.HashMap.empty[String, Boolean]
      dict.foreach(s => {
        val abbr = toAbbr(s)
        map.put(abbr, !map.contains(abbr))
      })
      map
    }

    def isUnique(word: String): Boolean = {
      val abbr = toAbbr(word)
      val hasAbbr = abbrDict.get(abbr)
      hasAbbr.isEmpty || (hasAbbr.get && dict.contains(word))
    }

    private def toAbbr(s: String): String = {
      val n = s.length
      if (n <= 2) s else s"${s.charAt(0)}${(n - 2).toString}${s.charAt(n - 1)}"
    }
  }

}
