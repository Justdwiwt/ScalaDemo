package leetCode

object Solution_2810 {
  def finalString(s: String): String = {
    var res = new StringBuilder
    s.toCharArray.foreach(c => if ('i' == c) res = res.reverse else res.append(c))
    res.mkString
  }
}
