package leetCode._2200

object Solution_2109 {
  def addSpaces(s: String, spaces: Array[Int]): String = {
    val res = new StringBuilder(s)
    spaces.indices.reverse.foreach(i => res.insert(spaces(i), ' '))
    res.mkString
  }
}
