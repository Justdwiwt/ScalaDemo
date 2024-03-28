package leetCode._1300

import scala.collection.mutable

object Solution_1297 {
  def maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int = {
    val cnt = mutable.HashMap.empty[String, Int]
    (0 until s.length - minSize + 1).foldLeft(cnt)((_, a) => {
      val word = s.substring(a, a + minSize)
      if (cnt.contains(word)) cnt.update(word, cnt.getOrElse(word, 0) + 1)
      else if (word.distinct.length <= maxLetters) cnt += word -> 1
      cnt
    })
    if (cnt.values.isEmpty) 0 else cnt.values.max
  }
}
