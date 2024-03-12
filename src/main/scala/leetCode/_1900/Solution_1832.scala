package leetCode._1900

object Solution_1832 {
  def checkIfPangram(sentence: String): Boolean =
    sentence.distinct.length == 26
}
