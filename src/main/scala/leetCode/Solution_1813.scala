package leetCode

object Solution_1813 {
  def areSentencesSimilar(sentence1: String, sentence2: String): Boolean = {
    val l1 = sentence1.split("\\s+").toVector
    val l2 = sentence2.split("\\s+").toVector
    val (x, y) = f(l1, l2)
    x.isEmpty || y.isEmpty
  }

  @scala.annotation.tailrec
  def f(l1: Vector[String], l2: Vector[String]): (Vector[String], Vector[String]) = (l1, l2) match {
    case (Vector(), _) => (l1, l2)
    case (_, Vector()) => (l1, l2)
    case (_, _) => if (l1.head == l2.head) f(l1.tail, l2.tail)
    else if (l1.last == l2.last) f(l1.dropRight(1), l2.dropRight(1))
    else (l1, l2)
  }
}
