package leetCode

object Solution_1408 {
  def stringMatching(words: Array[String]): List[String] = {
    val str = words.mkString("-")
    var res = List.empty[String]
    words.foreach(i => if (str.indexOf(i) != str.lastIndexOf(i)) res :+= i)
    res
  }
}
