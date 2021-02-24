package leetCode

object Solution_1758 {
  def minOperations(s: String): Int = {
    val t = s./:((0, (0, 0)))((s, ch) => {
      val i = s._1
      val c = s._2
      val v =
        if (i % 2 == 0)
          if (ch == '1') (c._1 + 1, c._2)
          else (c._1, c._2 + 1)
        else if (ch == '1') (c._1, c._2 + 1)
        else (c._1 + 1, c._2)
      (i + 1, v)
    })._2

    if (t._1 < t._2) t._1 else t._2
  }
}
