package leetCode._1500

object Solution_1436 {
  def destCity(paths: List[List[String]]): String = {
    val diff = paths.collect { case List(city, _) => city }
    paths.collect { case List(_, city) => city }.filterNot(diff.contains).head
  }
}
