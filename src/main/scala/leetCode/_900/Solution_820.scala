package leetCode._900

object Solution_820 {
  def minimumLengthEncoding(words: Array[String]): Int = words.length match {
    case 0 => 0
    case 1 => words(0).length + 1
    case _ =>
      words.indices.foreach(i => words(i) = words(i).reverse)
      val t = words.sorted
      var res = t(words.length - 1).length + 1
      (0 until words.length - 1).foreach(i => if (!check(t(i), t(i + 1))) res += t(i).length + 1)
      res
  }

  def check(s1: String, s2: String): Boolean = {
    (0 until s1.length).foreach(i => if (s1(i) != s2(i)) return false)
    true
  }
}
