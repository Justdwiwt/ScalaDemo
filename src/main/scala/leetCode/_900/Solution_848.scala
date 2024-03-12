package leetCode._900

object Solution_848 {
  def shiftingLetters(S: String, shifts: Array[Int]): String =
    shifts.:\(Seq.empty[Int])((s, m) => ((s + m.headOption.getOrElse(0)) % 26) +: m)
      .zip(S)
      .map(x => ('a' + ((x._2 - 'a') + x._1) % 26).toChar)
      .mkString
}
