package leetCode._1500

object Solution_1462 {
  def checkIfPrerequisite(n: Int, prerequisites: Array[Array[Int]], queries: Array[Array[Int]]): Array[Boolean] = queries
    .map(v => g(f(List.range(0, n), Map.empty[Int, Set[Int]], prerequisites), List.range(0, n)).getOrElse(v(1), Set.empty[Int]).contains(v.head))

  @scala.annotation.tailrec
  private def f(list: List[Int], m: Map[Int, Set[Int]], pre: Array[Array[Int]]): Map[Int, Set[Int]] = list match {
    case h :: t => f(t, Map(h -> pre.filter(_ (1) == h).map(_.head).toSet) ++ m, pre)
    case Nil => m
  }

  @scala.annotation.tailrec
  private def g(m: Map[Int, Set[Int]], list: List[Int]): Map[Int, Set[Int]] = list match {
    case h :: t => g(m.map(v => if (v._2.contains(h)) v._1 -> (v._2 ++ m.getOrElse(h, Set.empty[Int])) else v), t)
    case Nil => m
  }
}
