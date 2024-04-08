package leetCode._700

object Solution_616 {
  def addBoldTag(s: String, words: Array[String]): String = {
    val isBold = Array.fill(s.length)(false)

    words.foreach(word => {
      var n = s.indexOf(word, 0)
      while (n != -1) {
        (n until n + word.length).foreach(isBold(_) = true)
        n = s.indexOf(word, n + 1)
      }
    })

    val res = new StringBuilder
    if (isBold.head) res.append("<b>")

    isBold.indices.foreach(i => {
      res.append(s(i))
      if (i == isBold.length - 1) {
        if (isBold(i)) res.append("</b>")
      } else {
        if (isBold(i) && !isBold(i + 1)) res.append("</b>")
        if (!isBold(i) && isBold(i + 1)) res.append("<b>")
      }
    })

    res.mkString
  }
}
