package leetCode

object Solution_953 {
  def isAlienSorted(words: Array[String], order: String): Boolean = words
    .map(_.toList.map(c => (order.indexOf(c.toString) + 'a').toChar).mkString)
    .toList
    .sliding(2)
    .forall { case List(a, b) => a <= b; case _ => false }
}
