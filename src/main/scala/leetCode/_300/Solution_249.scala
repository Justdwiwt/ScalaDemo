package leetCode._300

object Solution_249 {
  def groupStrings(strings: Array[String]): List[List[String]] = strings
    .groupBy(str => str.map(c => (c - str.head + 26) % 26).mkString("#"))
    .values
    .map(_.toList)
    .toList
}
