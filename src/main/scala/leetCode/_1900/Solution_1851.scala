package leetCode._1900

import scala.collection.mutable

object Solution_1851 {
  def minInterval(_ivs: Array[Array[Int]], qs: Array[Int]): Array[Int] = {

    case class M(x: Int, c: Int, i: Int)

    val m, res = mutable.HashMap.empty[Int, Int]
    val arr = Array.ofDim[M](_ivs.length * 2 + qs.length)
    var idx = 0

    _ivs.zipWithIndex.foreach({ case (i, id) =>
      m += id -> (i(1) - i(0) + 1)
      arr(idx) = M(i(0), 1, id)
      arr(idx + 1) = M(i(1), -1, id)
      idx += 2
    })

    qs.foreach(q => {
      arr(idx) = M(q, -1, -100)
      idx += 1
    })

    val sorted = arr.sortWith((a, b) => {
      if (a.x != b.x) a.x <= b.x
      else if (a.c != b.c) a.c > b.c
      else a.i <= b.i
    })

    val tm = new mutable.TreeMap[Int, Int]()((a, b) => Integer.compare(m(a), m(b)))

    sorted.foreach(cur => {
      if (cur.c == 1) tm += cur.i -> (tm.getOrElse(cur.i, 0) + 1)
      else if (cur.c == -1 && cur.i != -100) {
        tm += cur.i -> (tm(cur.i) - 1)
        if (tm(cur.i) == 0) tm.remove(cur.i)
      } else res += cur.x -> (if (tm.isEmpty) -1 else m(tm.head._1))
    })

    qs.map(res(_))
  }
}
