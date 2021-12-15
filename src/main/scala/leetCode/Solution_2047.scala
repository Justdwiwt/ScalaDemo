package leetCode

object Solution_2047 {
  def countValidWords(sentence: String): Int = sentence
    .split(" ")
    .filter(_.nonEmpty)
    .count(w => {
      var c = w
      if ("!.,".indexOf(w.last) != -1)
        c = w.substring(0, w.length - 1)
      if (c.forall(_.isLetter))
        true
      else {
        val n = c.indexOf('-')
        if (n == -1 || n == 0 || n == c.length - 1)
          false
        else c
          .substring(0, n)
          .forall(_.isLetter) && c.substring(n + 1)
          .forall(_.isLetter)
      }
    })
}
