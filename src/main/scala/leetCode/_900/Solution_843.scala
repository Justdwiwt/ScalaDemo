package leetCode._900

object Solution_843 {

  class Master {
    def guess(word: String): Int = ???
  }

  @scala.annotation.tailrec
  def findSecretWord(wordlist: Array[String], master: Master): Unit = {
    val cnt = wordlist.flatten.groupBy(c => c).mapValues(_.length)
    val word = wordlist.maxBy(_.map(cnt).sum)
    val m = master.guess(word)
    if (m < word.length) findSecretWord(wordlist.filter(f(word, _) == m), master)
  }

  private def f(x: String, y: String): Int =
    x.zip(y).count(p => p._1 == p._2)
}
