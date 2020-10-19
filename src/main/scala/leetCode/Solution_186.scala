package leetCode

object Solution_186 {
  def reverseWords(s: Array[Char]): Unit = {
    var i = 0
    s.indices.foreach(j => if (s(j) == ' ') {
      reverse(s, i, j)
      i = j + 1
    })
    reverse(s, i, s.length)
    reverse(s, 0, s.length)
  }

  def reverse(str: Array[Char], i: Int, j: Int): Unit = {
    (i until (i + j) / 2).foreach(k => {
      val t = str(k)
      val g = j - 1 - k + i
      str(k) = str(g)
      str(g) = t
    })
  }
}
