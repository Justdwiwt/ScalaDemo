package leetCode._3600

object Solution_3501 {
  private def bitLength(n: Int): Int =
    if (n > 0) 32 - Integer.numberOfLeadingZeros(n) else 0

  private def bisectLeft(a: Vector[(Int, Int)], x: Int): Int = {
    @scala.annotation.tailrec
    def rec(low: Int, high: Int): Int =
      if (low >= high) low
      else {
        val mid = (low + high) >>> 1
        if (a(mid)._1 < x) rec(mid + 1, high)
        else rec(low, mid)
      }

    rec(0, a.length)
  }

  private def bisectRight(a: Vector[(Int, Int)], x: Int): Int = {
    @scala.annotation.tailrec
    def rec(low: Int, high: Int): Int =
      if (low >= high) low
      else {
        val mid = (low + high) >>> 1
        if (a(mid)._2 <= x) rec(mid + 1, high)
        else rec(low, mid)
      }

    rec(0, a.length)
  }

  private class SparseTable(val st: Vector[Vector[Int]]) {
    def query(l: Int, r: Int): Int =
      if (l >= r) 0
      else {
        val len = r - l
        val k = bitLength(len) - 1
        st(k)(l).max(st(k)(r - (1 << k)))
      }
  }

  private def buildSparseTable(a: Vector[(Int, Int)]): SparseTable = {
    val n = a.length - 1
    val m = bitLength(n)
    val st0: Vector[Int] = a.indices.dropRight(1).map(i => {
      val (l1, r1) = a(i)
      val (l2, r2) = a(i + 1)
      (r1 - l1) + (r2 - l2)
    }).toVector
    val stCols: Vector[Vector[Int]] = (0 until m).foldLeft(Vector.empty[Vector[Int]])((cols, j) => {
      if (j == 0) cols :+ st0
      else {
        val prev = cols(j - 1)
        val size = n - (1 << j) + 1
        val nextCol = (0 until size).map(i => prev(i).max(prev(i + (1 << (j - 1))))).toVector
        cols :+ nextCol
      }
    })
    new SparseTable(stCols)
  }

  private def calc(x: Int, y: Int): Int =
    if (x > 0 && y > 0) x + y else 0

  def maxActiveSectionsAfterTrade(s: String, queries: Array[Array[Int]]): List[Int] = {
    val n = s.length

    @scala.annotation.tailrec
    def loop(i: Int, start: Int, total1: Int, accIntervals: List[(Int, Int)]): (Int, List[(Int, Int)]) =
      if (i >= n) (total1, accIntervals)
      else if (i == n - 1 || s(i) != s(i + 1)) {
        if (s(i) == '1') loop(i + 1, i + 1, total1 + (i - start + 1), accIntervals)
        else loop(i + 1, i + 1, total1, (start, i + 1) :: accIntervals)
      } else loop(i + 1, start, total1, accIntervals)

    val (total1, intervalsRev) = loop(0, 0, 0, Nil)
    val a: Vector[(Int, Int)] = (List((-1, -1)) ++ intervalsRev.reverse ++ List((n + 1, n + 1))).toVector

    val stOpt: Option[SparseTable] = if (a.length >= 2) Some(buildSparseTable(a)) else None

    val res = queries.iterator.map(query => {
      val ql = query.head
      val qr = query(1) + 1
      val i = bisectLeft(a, ql)
      val j = bisectRight(a, qr) - 1
      val mx =
        if (i <= j) {
          val cand1 = stOpt.map(_.query(i, j)).getOrElse(0)
          val cand2 = if (i - 1 >= 0 && i < a.length) calc(a(i - 1)._2 - ql, a(i)._2 - a(i)._1) else 0
          val cand3 = if (j + 1 < a.length && j >= 0) calc(qr - a(j + 1)._1, a(j)._2 - a(j)._1) else 0
          Seq(cand1, cand2, cand3).max
        } else if (i == j + 1) {
          if (i - 1 >= 0 && j + 1 < a.length) calc(a(i - 1)._2 - ql, qr - a(j + 1)._1)
          else 0
        } else 0
      total1 + mx
    }).toList

    res
  }
}
