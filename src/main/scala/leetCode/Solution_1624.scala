package leetCode

object Solution_1624 {
  def maxLengthBetweenEqualCharacters(s: String): Int =
    s.indices./:((Map.empty[Char, Int], -1))((acc, x) => {
      acc._1.get(s(x)) match {
        case None => (acc._1.updated(s(x), x), acc._2)
        case Some(v) => (acc._1, (x - v - 1).max(acc._2))
      }
    })._2
}
