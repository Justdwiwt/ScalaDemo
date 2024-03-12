package leetCode._800

object Solution_720 {
  def longestWord(words: Array[String]): String = {
    words.sortWith((s1: String, s2: String) => if (s1.length == s2.length) s1 < s2 else s1.length > s2.length)
      .foreach(s => if ((1 until s.length).forall(i => words.contains(s.substring(0, i)))) return s)
    ""
  }
}
