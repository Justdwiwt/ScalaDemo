package leetCode._800

object Solution_758 {
  def boldWords(words: Array[String], S: String): String = {
    val isBold = Array.fill(S.length)(false)

    words.foreach(word => {
      var n = S.indexOf(word, 0)
      while (n != -1) {
        (n until n + word.length).foreach(isBold(_) = true)
        n = S.indexOf(word, n + 1)
      }
    })

    val res = new StringBuilder
    if (isBold.head) res.append("<b>")

    isBold.indices.foreach(i => {
      res.append(S.charAt(i))
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
