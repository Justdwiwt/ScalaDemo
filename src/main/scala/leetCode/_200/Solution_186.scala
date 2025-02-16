package leetCode._200

object Solution_186 {
  def reverseWords(s: Array[Char]): Unit = {
    def reverse(str: Array[Char], i: Int, j: Int): Unit = {
      (0 until (j - i) / 2).foreach(k => {
        val g = j - 1 - k
        val t = str(i + k)
        str(i + k) = str(g)
        str(g) = t
      })
    }

    val indices = s.zipWithIndex.collect { case (' ', idx) => idx }
    (indices :+ s.length).foldLeft(0)((start, end) => {
      reverse(s, start, end)
      end + 1
    })

    reverse(s, 0, s.length)
  }
}
