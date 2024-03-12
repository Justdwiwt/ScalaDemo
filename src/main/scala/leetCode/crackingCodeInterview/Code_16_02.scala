package leetCode.crackingCodeInterview

import scala.collection.mutable

object Code_16_02 {
  class WordsFrequency(_book: Array[String]) {
    var m = mutable.HashMap.empty[String, Int]
    _book.foreach(w => m += w -> (m.getOrElse(w, 0) + 1))

    def get(word: String): Int =
      m.getOrElse(word, 0)
  }
}
