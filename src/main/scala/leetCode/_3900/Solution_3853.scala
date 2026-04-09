package leetCode._3900

object Solution_3853 {
  def mergeCharacters(s: String, k: Int): String = s
    .foldLeft((Map.empty[Char, Int], Vector.empty[Char])) {
      case ((last, ans), ch) =>
        last.get(ch) match {
          case Some(pos) if ans.length - pos <= k => (last, ans)
          case _ => (last.updated(ch, ans.length), ans :+ ch)
        }
    }
    ._2
    .mkString
}
