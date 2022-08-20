package leetCode

object Solution_2375 {
  def smallestNumber(pattern: String): String = (0 to pattern.length)
    ./:(Array.empty[Int], Array.empty[Int]) { case ((res, st), i) =>
      if (i < pattern.length && pattern(i) == 'D') (res, st :+ (i + 1))
      else ((res :+ (i + 1)) ++ st.reverse, Array.empty)
    }
    ._1
    .mkString
}
