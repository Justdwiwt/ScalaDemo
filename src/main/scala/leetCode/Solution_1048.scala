package leetCode

import scala.collection.mutable

object Solution_1048 {
  def longestStrChain(words: Array[String]): Int = {
    val m = mutable.Map.empty[String, Int].withDefaultValue(0)

    def f(str: String): Int = {
      if (!words.contains(str)) return 0
      m.get(str) match {
        case Some(res) => res
        case _ =>
          val res = str.indices.map(i => {
            val pre = str.substring(0, i) + str.substring(i + 1)
            f(pre) + 1
          }).max
          m(str) = res
          res
      }
    }

    words.map(f).max
  }
}
