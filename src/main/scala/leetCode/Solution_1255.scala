package leetCode

import scala.util.control.Breaks._

object Solution_1255 {
  def maxScoreWords(words: Array[String], letters: Array[Char], score: Array[Int]): Int = {
    val l = Array.fill(26)(0)
    letters.foreach(i => l(i - 'a') += 1)
    var res = 0
    (0 until (1 << words.length)).foreach(i => {
      val v = group(words, i)
      var t = 0
      breakable {
        (0 until 26).foreach(j => {
          if (l(j) < v(j)) {
            t = 0
            break
          } else t += v(j) * score(j)
        })
      }
      res = res.max(t)
    })
    res
  }

  def group(words: Array[String], bit: Int): Array[Int] = {
    val res = Array.fill(26)(0)
    words.indices.foreach(i => if ((bit & (1 << i)) > 0) words(i).foreach(j => res(j - 'a') += 1))
    res
  }
}
