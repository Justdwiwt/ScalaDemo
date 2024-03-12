package leetCode._2300

object Solution_2273 {
  def removeAnagrams(words: Array[String]): List[String] = words
    .indices
    .collect { case i if i == 0 || words(i).sorted != words(i - 1).sorted => words(i) }
    .toList
}
