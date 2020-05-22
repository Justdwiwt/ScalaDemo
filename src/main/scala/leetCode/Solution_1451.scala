package leetCode

object Solution_1451 {
  def arrangeWords(text: String): String = {
    val s = text.toLowerCase.split(" ")
    val str = s.sortWith(_.length < _.length)
    var first = str(0).charAt(0)
    first = (first - 32).toChar
    val t = first + str(0).substring(1)
    str(0) = t
    str.mkString(" ")
  }
}
