package leetCode._400

object Solution_320 {
  def generateAbbreviations(word: String): List[String] = {
    var res = List.empty[String]

    def f(word: String, start: Int): Unit = {
      (start until word.length).foreach(i => (1 to word.length - i).foreach(j => {
        var t = word.substring(0, i) + j + word.substring(i + j)
        res ::= t
        f(t, i + ("" + j).length + 1)
      }))
    }

    f(word, 0)
    res ::= word
    res
  }
}
