package leetCode

object Solution_890 {
  @inline
  def check[A](sq: Seq[(A, A)]): Boolean = sq.toSet.groupBy((p: (A, A)) => p._1).forall(_._2.size == 1)

  def findAndReplacePattern(words: Array[String], pattern: String): List[String] = {
    words.toList.filter(word => check(word.zip(pattern)) && check(pattern.zip(word)))
  }
}
