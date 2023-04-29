package leetCode

object Solution_1697 {
  def distanceLimitedPathsExist(n: Int, edgeList: Array[Array[Int]], queries: Array[Array[Int]]): Array[Boolean] = {
    val arr = (0 until n).toArray

    @scala.annotation.tailrec
    def cmp(i: Int, p: Int): Unit = if (i != p) {
      val oldP = arr(i)
      arr(i) = p
      cmp(oldP, p)
    }

    @scala.annotation.tailrec
    def _root(i: Int): Int =
      if (arr(i) == i) arr(i)
      else _root(arr(i))

    def root(i: Int): Int = {
      val r = _root(i)
      cmp(i, r)
      r
    }

    def join(i: Int, j: Int): Unit =
      arr(root(j)) = root(i)

    @scala.annotation.tailrec
    def f(es: Seq[Seq[Int]], qs: Seq[(Seq[Int], Int)], acc: Seq[(Boolean, Int)]): Seq[(Boolean, Int)] = {
      lazy val (eh, et) = (es.head, es.tail)
      lazy val ((qh, qhi), qt) = (qs.head, qs.tail)
      if (qs.isEmpty) acc
      else if (es.nonEmpty && (eh(2) < qh(2))) {
        join(eh.head, eh(1))
        f(et, qs, acc)
      }
      else f(es, qt, ((root(qh.head) == root(qh(1))) -> qhi) +: acc)
    }

    lazy val es = edgeList.toList.sortBy(_(2)).map(_.toVector)
    lazy val qs = queries.map(_.toVector).toList.zipWithIndex.sortBy(_._1(2))
    f(es, qs, Nil).sortBy(_._2).map(_._1).toArray
  }
}
