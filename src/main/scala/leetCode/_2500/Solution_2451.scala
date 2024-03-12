package leetCode._2500

object Solution_2451 {
  def oddString(words: Array[String]): String =
    if (checkStringsAreOfSameLength(words)) {
      val diff = words.map(stringToIntDifference)
      val Array(a1, a2, a3) = diff.take(3)
      val sameArray = findSameArrIn3Arrays(a1, a2, a3)
      val diffArrIdx = diff.map(compare2Arrays(_, sameArray)).zipWithIndex.filter { case (condition, _) => !condition }.head._2
      words(diffArrIdx)
    }
    else "Strings are not of same length in Array"

  def checkStringsAreOfSameLength(words: Array[String]): Boolean = words
    .map(_.length)
    .distinct
    .length == 1

  def stringToIntDifference(word: String): Array[Int] = word
    .sliding(2)
    .map(x => x(1) - x.head)
    .toArray

  def compare2Arrays(a1: Array[Int], a2: Array[Int]): Boolean = a1
    .zip(a2)
    .map { case (x, y) => x == y }
    .reduce(_ && _)

  def findSameArrIn3Arrays(a1: Array[Int], a2: Array[Int], a3: Array[Int]): Array[Int] =
    if (compare2Arrays(a1, a2)) a1
    else if (compare2Arrays(a2, a3)) a2
    else a3
}
