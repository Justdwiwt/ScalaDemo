package leetCode._800

object Solution_748 {
  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = words
    .filter(x => geWordVect(wordVect(x), wordVect(licensePlate.toLowerCase.replaceAll("[0-9 ]*", ""))))
    .minBy(_.length)

  private def geWordVect(word: Array[Int], lp: Array[Int]): Boolean =
    word.zip(lp).forall(x => x._1 >= x._2)

  private def wordVect(word: String): Array[Int] = word
    .map(_ - 'a')
    .foldLeft(Array.fill(26)(0))((res, idx) => res.updated(idx, res(idx) + 1))
}
