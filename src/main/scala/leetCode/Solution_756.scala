package leetCode

object Solution_756 {
  def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {
    def cross[A](a: List[List[A]]): List[List[A]] =
      a.:\(List[List[A]](Nil))((l, kss) => kss.flatMap(k => l.map(_ :: k)))

    def nextRow(row: List[Char], allowed: List[List[Char]]): List[List[Char]] =
      cross(row.sliding(2).map(x => allowed.filter(_.startsWith(x)).map(_ (2))).toList).distinct

    def init(allowed: List[List[Char]])(row: List[Char]): Boolean =
      row.length <= 1 || nextRow(row, allowed).exists(init(allowed))

    init(allowed.map(_.toList))(bottom.toList)
  }
}
