package leetCode

import scala.collection.mutable

object Solution_1160 {
  def countCharacters(words: Array[String], chars: String): Int = {
    val chCnt = mutable.HashMap.empty[Char, Int]
    chars.foreach(ch => chCnt += ch -> (chCnt.getOrElse(ch, 0) + 1))
    var res = 0
    words.foreach(word => {
      val wordCnt = mutable.HashMap.empty[Char, Int]
      word.foreach(ch => wordCnt += ch -> (wordCnt.getOrElse(ch, 0) + 1))
      var flag = true
      wordCnt.foreach({ case (ch, count) => if (!chCnt.contains(ch) || chCnt(ch) < count) flag = false })
      if (flag) res += word.length
    })
    res
  }
}
