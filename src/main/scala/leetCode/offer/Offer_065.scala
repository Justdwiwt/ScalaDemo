package leetCode.offer

object Offer_065 {
  def minimumLengthEncoding(words: Array[String]): Int = words.length match {
    case 0 => 0
    case 1 => words.head.length + 1
    case _ =>
      words.indices.foreach(i => words(i) = words(i).reverse)
      val sorted = words.sorted
      var res = sorted(words.length - 1).length + 1
      words.indices.dropRight(1).foreach(i => if (!check(sorted(i), sorted(i + 1))) res += sorted(i).length + 1)
      res
  }

  def check(s1: String, s2: String): Boolean = {
    s1.indices.foreach(i => if (s1(i) != s2(i)) return false)
    true
  }
}
