package leetCode

object Solution_1974 {
  def minTimeToType(word: String): Int = {
    var res = word.length
    var cur = 'a'
    word.toCharArray.foreach(ch => {
      val t = (ch - cur).abs
      res += t.min(26 - t)
      cur = ch
    })
    res
  }
}
