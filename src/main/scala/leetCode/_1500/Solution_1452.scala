package leetCode._1500

object Solution_1452 {
  def peopleIndexes(favoriteCompanies: List[List[String]]): List[Int] = {
    val sq = favoriteCompanies.map(_.toSet).zipWithIndex
    sq.filter { case (x, y) => !sq.exists { case (x1, y1) => x.subsetOf(x1) && y1 != y } }.map(_._2)
  }
}
