package leetCode

object Solution_1832 {
  def checkIfPangram(sentence: String): Boolean =
    sentence.distinct.length == 26
}
