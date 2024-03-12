package leetCode._2000

object Solution_1961 {
  def isPrefixString(s: String, words: Array[String]): Boolean = {
    var arr = Array.empty[String]
    words.indices.foreach(i => {
      arr :+= words(i)
      if (arr.mkString.equals(s)) return true
    })
    false
  }
}
