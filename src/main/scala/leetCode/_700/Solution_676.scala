package leetCode._700

import scala.collection.mutable

object Solution_676 {

  class MagicDictionary() {
    val dict: mutable.Set[String] = mutable.Set.empty[String]

    def buildDict(dictionary: Array[String]): dict.type =
      dict ++= dictionary

    def search(searchWord: String): Boolean = searchWord
      .indices
      .flatMap(i => ('a' to 'z').filter(_ != searchWord(i)).map(searchWord.updated(i, _)))
      .exists(dict.contains)
  }

}
