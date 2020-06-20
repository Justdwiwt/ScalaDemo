package leetCode

object Solution_953 {
  def isAlienSorted(words: Array[String], order: String): Boolean = {
    var s = ""

    def f(a: String, b: String): Boolean = {
      var i = 0
      while (i < a.length && i < b.length && a(0) == b(i)) i += 1
      if (i == a.length || i == b.length) a.length < b.length
      else s.indexOf(a(i)) < s.indexOf(b(i))
    }

    s = order
    (1 until words.length).foreach(i => if (!f(words(i - 1), words(i))) return false)
    true
  }
}
