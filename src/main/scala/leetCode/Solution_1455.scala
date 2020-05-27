package leetCode

object Solution_1455 {
  def isPrefixOfWord(sentence: String, searchWord: String): Int = {
    val t = sentence.split(" ")
    t.indices.foreach(i => if (t(i).length >= searchWord.length && t(i).substring(0, searchWord.length).equals(searchWord)) return i + 1)
    -1
  }
}
