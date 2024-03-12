package leetCode._1800

object Solution_1768 {
  def mergeAlternately(word1: String, word2: String): String = {
    val n = word1.length
    val m = word2.length
    var idx = 0
    val res = new StringBuilder
    while (idx < n && idx < m) {
      res.append(word1.charAt(idx)).append(word2.charAt(idx))
      idx += 1
    }
    res.append(word1.substring(idx, n)).append(word2.substring(idx, m))
    res.mkString
  }
}
