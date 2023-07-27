package leetCode

object Solution_2788 {
  def splitWordsBySeparator(words: List[String], separator: Char): List[String] = {
    var res = List.empty[String]
    val ss = "\\" + separator.toString
    words.foreach(w => {
      val s = w.split(ss)
      s.foreach(t => if (t.nonEmpty) res ::= t)
    })
    res.reverse
  }
}
