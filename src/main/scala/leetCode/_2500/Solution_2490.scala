package leetCode._2500

object Solution_2490 {
  def isCircularSentence(sentence: String): Boolean = sentence
    .split(" ")
    .sliding(2)
    .filter(_.length == 2)
    .forall(p => p.head.last == p(1).head) && sentence.head == sentence.last
}
