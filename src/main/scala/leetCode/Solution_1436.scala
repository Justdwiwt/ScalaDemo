package leetCode

object Solution_1436 {
  def destCity(paths: List[List[String]]): String = {
    val diff = paths.map(_.head)
    paths.map({ case List(_, x) => x }).filterNot(diff.contains).head
  }
}
