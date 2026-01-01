package leetCode._3700

import scala.collection.immutable.TreeSet

object Solution_3691 {
  def maxTotalValue(nums: Array[Int], k: Int): Long = {
    val n = nums.length
    if (n == 0 || k == 0) return 0

    val w = 32 - Integer.numberOfLeadingZeros(n)
    val st = Array.tabulate(w, n)((_, _) => (0, 0))

    (0 until n).foreach(i => st(0)(i) = (nums(i), nums(i)))

    def op(a: (Int, Int), b: (Int, Int)) =
      (math.min(a._1, b._1), math.max(a._2, b._2))

    (1 until w).foreach(lev => {
      val len = 1 << lev
      val half = len >> 1
      (0 to n - len).foreach(j => st(lev)(j) = op(st(lev - 1)(j), st(lev - 1)(j + half)))
    })

    def query(l: Int, r: Int): Int =
      if (l >= r) 0
      else {
        val len = r - l
        val t = 31 - Integer.numberOfLeadingZeros(len)
        val (mn, mx) = op(st(t)(l), st(t)(r - (1 << t)))
        mx - mn
      }

    case class Node(d: Int, l: Int, r: Int)

    implicit val ord: Ordering[Node] =
      Ordering.by((x: Node) => (x.d, -x.l, -x.r))

    val init = TreeSet.empty[Node] + Node(query(0, n), 0, n)

    @scala.annotation.tailrec
    def loop(t: Int, ts: TreeSet[Node], acc: Long): Long =
      if (t == 0 || ts.isEmpty) acc
      else {
        val max = ts.last
        if (max.d == 0) acc
        else {
          val removed = ts - max
          val a = removed + Node(query(max.l, max.r - 1), max.l, max.r - 1)
          val b = if (max.r == n && max.l + 1 < n) a + Node(query(max.l + 1, n), max.l + 1, n) else a
          loop(t - 1, b, acc + max.d)
        }
      }

    loop(k, init, 0L)
  }
}
