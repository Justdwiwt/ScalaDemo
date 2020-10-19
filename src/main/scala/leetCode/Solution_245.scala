package leetCode

object Solution_245 {
  def shortestWordDistance(words: Array[String], word1: String, word2: String): Int = {
    var res = Int.MaxValue
    if (word1.equals(word2)) {
      var arr = Array.emptyIntArray
      words.indices.foreach(i => if (word1.equals(words(i))) arr :+= i)
      (1 until arr.length).foreach(i => res = res.min(arr(i) - arr(i - 1)))
    } else {
      var idx1 = -1
      var idx2 = -1
      words.indices.foreach(i => {
        if (words(i).equals(word1)) idx1 = i
        if (words(i).equals(word2)) idx2 = i
        if (idx1 != -1 && idx2 != -1) res = res.min((idx1 - idx2).abs)
      })
    }
    res
  }
}
