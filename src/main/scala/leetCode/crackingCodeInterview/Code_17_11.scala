package leetCode.crackingCodeInterview

object Code_17_11 {
  def findClosest(words: Array[String], word1: String, word2: String): Int = {
    var start = -10000
    var end = 10000
    var mn = 10000
    words.indices.foreach(i => {
      if (words(i).equals(word1)) start = i
      if (words(i).equals(word2)) end = i
      mn = mn.min((end - start).abs)
    })
    mn
  }
}
