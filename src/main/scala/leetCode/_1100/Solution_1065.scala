package leetCode._1100

object Solution_1065 {
  def indexPairs(text: String, words: Array[String]): Array[Array[Int]] = text
    .indices
    .flatMap(i => (i to text.length).flatMap(j => if (words.toSet.contains(text.substring(i, j))) Some(Array(i, j - 1)) else None))
    .toArray
}
