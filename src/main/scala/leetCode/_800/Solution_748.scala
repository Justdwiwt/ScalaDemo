package leetCode._800

object Solution_748 {
  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
    val lp = licensePlate.toLowerCase.replaceAll("[0-9 ]*", "")
    val lpv = wordVect(lp)
    words.filter(x => geWordVect(wordVect(x), lpv)).minBy(_.length)
  }

  def geWordVect(word: Array[Int], lp: Array[Int]): Boolean = {
    (word zip lp).forall(x => x._1 >= x._2)
  }

  def wordVect(word: String): Array[Int] = {
    val ans = Array.fill(26)(0)
    word.foreach(x => ans(x - 'a') += 1)
    ans
  }
}
