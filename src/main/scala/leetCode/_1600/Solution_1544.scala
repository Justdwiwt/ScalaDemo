package leetCode._1600

object Solution_1544 {
  def makeGood(s: String): String = s
    .foldLeft(Seq.empty[Char])((prev, ch) => {
      prev.lastOption match {
        case Some(ch0) if (ch0 ^ 32).toChar == ch => prev.dropRight(1)
        case _ => prev :+ ch
      }
    })
    .mkString
}
