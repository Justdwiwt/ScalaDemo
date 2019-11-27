package leetCode

import scala.collection.mutable

object Solution_745 {

  class WordFilter(_words: Array[String]) {

    private val m = new mutable.HashMap[String, Int]()

    _words.indices.foreach(k => _words(k).indices.foreach(i => _words(k).indices.foreach(j =>
      m(_words(k).substring(0, i) + "#" + _words(k).substring(_words(k).length - j)) = k)))

    def f(prefix: String, suffix: String): Int = if (m.contains(prefix + "#" + suffix)) m(prefix + "#" + suffix) else -1

  }

}

