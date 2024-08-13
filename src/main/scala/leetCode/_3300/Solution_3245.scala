package leetCode._3300

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution_3245 {
  private class FenwickTree(n: Int) {
    private val t = Array.fill(n + 1, 2)(0)

    def update(size: Int, op: Int): Unit = {
      @scala.annotation.tailrec
      def f(i: Int): Unit =
        if (i < t.length) {
          t(i)(0) += op
          t(i)(1) += op * size
          f(i + (i & -i))
        }

      f(t.length - size)
    }

    def query(size: Int): (Int, Int) = {
      @scala.annotation.tailrec
      def f(i: Int, acc: (Int, Int)): (Int, Int) =
        if (i > 0) {
          val updatedAcc = (acc._1 + t(i).head, acc._2 + t(i)(1))
          f(i & (i - 1), updatedAcc)
        } else acc

      f(t.length - size, (0, 0))
    }
  }

  def numberOfAlternatingGroups(a: Array[Int], queries: Array[Array[Int]]): List[Int] = {
    val n = a.length
    val ts = mutable.TreeSet.empty[Int]
    val t = new FenwickTree(n)

    def add(i: Int): Unit = {
      if (ts.isEmpty) t.update(n, 1)
      else update(i, 1)
      ts.add(i)
    }

    def del(i: Int): Unit = {
      ts.remove(i)
      if (ts.isEmpty) t.update(n, -1)
      else update(i, -1)
    }

    def update(i: Int, op: Int): Unit = {
      val pre = Option(ts.to(i).lastOption).flatten.getOrElse(ts.last)
      val nxt = Option(ts.from(i).headOption).flatten.getOrElse(ts.head)

      t.update((nxt - pre + n - 1) % n + 1, -op)
      t.update((i - pre + n) % n, op)
      t.update((nxt - i + n) % n, op)
    }

    (0 until n).foreach(i => if (a(i) == a((i + 1) % n)) add(i))

    queries.foldLeft(ArrayBuffer.empty[Int])((acc, q) => {
      q.head match {
        case 1 =>
          if (ts.isEmpty) acc += n
          else {
            val (cnt, sum) = t.query(q(1))
            acc += (sum - cnt * (q(1) - 1))
          }
        case _ =>
          val i = q(1)
          if (a(i) != q(2)) {
            val pre = (i - 1 + n) % n
            val nxt = (i + 1) % n
            if (a(pre) == a(i)) del(pre)
            if (a(i) == a(nxt)) del(i)
            a(i) ^= 1
            if (a(pre) == a(i)) add(pre)
            if (a(i) == a(nxt)) add(i)
          }
      }
      acc
    }).toList
  }
}
