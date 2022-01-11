package leetCode

object Solution_2129 {
  def capitalizeTitle(title: String): String = title
    .split(' ')
    .map(w => if (w.length <= 2) w.map(_.toLower) else w.take(1).toUpperCase + w.drop(1).toLowerCase)
    .mkString(" ")
}
