package leetCode._2500

object Solution_2452 {
  def twoEditWords(queries: Array[String], dictionary: Array[String]): List[String] = queries
    .filter(word => dictionary.exists(dword => word.indices./:(0) {
      case (3, _) => 3
      case (acc, i) => if (word(i) == dword(i)) acc else acc + 1
    } < 3))
    .toList
}
