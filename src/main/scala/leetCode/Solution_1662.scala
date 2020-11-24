package leetCode

object Solution_1662 {
  def arrayStringsAreEqual(word1: Array[String], word2: Array[String]): Boolean = {
    val w1 = word1./:("")(_ ++ _)
    val w2 = word2./:("")(_ ++ _)
    var res = true
    var cnt = 0
    while (res && (cnt < w1.length) && (cnt < w2.length)) {
      res = w1(cnt) == w2(cnt)
      cnt += 1
    }
    res
  }
}
