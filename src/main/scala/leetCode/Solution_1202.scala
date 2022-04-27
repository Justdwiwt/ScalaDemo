package leetCode

import scala.collection.mutable

object Solution_1202 {
  def smallestStringWithSwaps(s: String, pairs: List[List[Int]]): String = {
    @scala.annotation.tailrec
    def find(i: Int, uf: Array[Int]): Int =
      if (i != uf(i)) find(uf(i), uf)
      else i

    def union(i: Int, j: Int, uf: Array[Int]): Unit = {
      val iRoot = find(i, uf)
      val jRoot = find(j, uf)
      if (iRoot < jRoot) uf(jRoot) = iRoot
      else if (iRoot > jRoot) uf(iRoot) = jRoot
    }

    val uf = Array.ofDim[Int](s.length)
    val m = mutable.HashMap.empty[Int, List[Int]]

    s.indices.foreach(i => uf(i) = i)
    pairs.foreach(p => union(p.head, p(1), uf))

    uf.indices.foreach(i => {
      val r = find(i, uf)
      m.get(r) match {
        case None => m.put(r, List(i))
        case Some(ls) => m.put(r, i +: ls)
      }
    })

    m.toList.flatMap { case (_, ns) =>
      val (ms, cs) = ns.map(n => (n, s(n))).unzip
      ms.sorted.zip(cs.sorted)
    }.sortBy(_._1).map(_._2).mkString("")
  }
}
