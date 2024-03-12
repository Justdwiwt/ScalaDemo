package leetCode._1900

object Solution_1813 {
  def areSentencesSimilar(sentence1: String, sentence2: String): Boolean = {
    @scala.annotation.tailrec
    def f(s1: List[String], s2: List[String]): Boolean = (s1, s2) match {
      case (Nil, _) => true
      case (_, Nil) => true
      case (h1 +: r1, h2 +: r2) if h1 == h2 => f(r1, r2)
      case (r1 :+ t1, r2 :+ t2) if t1 == t2 => f(r1, r2)
      case _ => false
    }

    f(sentence1.split(" ").toList, sentence2.split(" ").toList)
  }
}
