package leetCode

object Solution_942 {
  def diStringMatch(S: String): Array[Int] =
    (S + "I")./:((Array.empty[Int], 0, S.length)) { case ((arr, small, big), ch) =>
      if (ch == 'I') (arr :+ small, small + 1, big)
      else (arr :+ big, small, big - 1)
    }._1
}
