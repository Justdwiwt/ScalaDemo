package leetCode._3900

object Solution_3838 {
  def mapWordWeights(words: Array[String], weights: Array[Int]): String = {
    words.map(_.map(c => weights(c.asNum)).sum.reverseChar).mkString
  }

  implicit class ToNum(c: Char) {
    def asNum: Int = c - 'a'
  }

  implicit class ToChar(i: Int) {
    def reverseChar: Char = ('z' - (i % 26)).toChar
  }
}
