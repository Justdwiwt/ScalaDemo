package leetCode._1600

import scala.collection.mutable

object Solution_1514 {
  def maxProbability(n: Int, edges: Array[Array[Int]], succProb: Array[Double], start: Int, end: Int): Double = {
    val res = Array.fill(n)(0d)
    res(start) = 1d
    f(res,
      edges.zip(succProb)./:(Array.fill(n)(Seq.empty[(Int, Double)]))((g, e) => {
        g(e._1.head) = (e._1.last, e._2) +: g(e._1.head)
        g(e._1.last) = (e._1.head, e._2) +: g(e._1.last)
        g
      }),
      mutable.Set(start)
    )(end)
  }

  @scala.annotation.tailrec
  def f(r: Array[Double], g: Array[Seq[(Int, Double)]], s: mutable.Set[Int]): Array[Double] = {
    if (s.isEmpty) r
    else {
      val h = s.head
      s -= h
      val nq = g(h).map(e => e._1 -> r(h) * e._2).filter(e => e._2 > r(e._1)).map({ e => r(e._1) = e._2; e._1 })
      s ++= nq
      f(r, g, s)
    }
  }
}
