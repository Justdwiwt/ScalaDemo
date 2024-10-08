package leetCode._3400

import scala.collection.mutable

object Solution_3310 {
  def remainingMethods(n: Int, k: Int, invocations: Array[Array[Int]]): List[Int] = {
    val m = mutable.Map.empty[Int, List[Int]]
    invocations.foreach { case Array(from, to) => m.update(from, to :: m.getOrElse(from, Nil)) }

    @scala.annotation.tailrec
    def f(vs: List[Int], seen: Set[Int]): Set[Int] = {
      val next = vs.flatMap(m.getOrElse(_, Nil))
      if (next.isEmpty) seen ++ vs else f(next.filterNot(seen.contains), seen ++ vs)
    }

    val suspected = f(List(k), Set.empty)
    val list = (0 until n).toList
    if ((m.keys.toSet -- suspected).exists(m(_).exists(suspected.contains))) list
    else list.filterNot(suspected.contains)
  }
}
