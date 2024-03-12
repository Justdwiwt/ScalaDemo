package leetCode._1900

object Solution_1805 {
  def numDifferentIntegers(word: String): Int = word
    .replaceAll("[a-z]", " ")
    .split(" ")
    .filter(_.trim.nonEmpty)
    .map(BigInt(_))
    .distinct
    .length
}
