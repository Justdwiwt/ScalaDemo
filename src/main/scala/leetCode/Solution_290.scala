package leetCode

object Solution_290 {

  case class res(str: String)

  def wordPattern(pattern: String, str: String): Boolean = {
    val words = str.split(" ")
    if (pattern.length != words.length) return false
    val a1 = res(pattern.toCharArray.zip(words).distinct.map(_._1).mkString)
    val b1 = res(pattern.toCharArray.distinct.mkString)
    val a2 = res(pattern.toCharArray.zip(words).distinct.map(_._2).mkString)
    val b2 = res(words.distinct.mkString)
    a1 == b1 && a2 == b2
  }
}
