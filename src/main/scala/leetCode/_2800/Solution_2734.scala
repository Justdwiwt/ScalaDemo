package leetCode._2800

object Solution_2734 {
  def smallestString(s: String): String = {
    val (prefA, res) = s.span(_ == 'a')
    if (res == "") prefA.init :+ 'z'
    else {
      val (sub, suf) = res.span(_ != 'a')
      prefA + sub.map(c => (c - 1).toChar).mkString + suf
    }
  }
}
