package leetCode._1200

object Solution_1180 {
  def countLetters(s: String): Int = s
    .indices
    .drop(1)
    .foldLeft((1, 0)) { case ((cnt, res), i) =>
      if (s(i) == s(i - 1)) (cnt + 1, res)
      else (1, res + cnt * (cnt + 1) / 2)
    }
  match {
    case (cnt, res) => res + cnt * (cnt + 1) / 2
  }
}
