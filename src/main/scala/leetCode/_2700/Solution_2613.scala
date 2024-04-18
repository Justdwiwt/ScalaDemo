package leetCode._2700

import scala.collection.mutable

object Solution_2613 {
  // fixme: case 76/105 wrong answer
  def beautifulPair(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val n = nums1.length
    val arr = nums1.zip(nums2).zipWithIndex.map { case ((x, y), i) => Array(x + y, x - y, i) }
    val sorted = arr.sortBy(a => (a.head, a(1)))

    var l = -1
    var r = n + 5

    def check(mid: Int): Boolean = {
      val st = mutable.SortedSet.empty[(Int, Int)]
      val q = mutable.Queue.empty[Array[Int]]

      var found = false

      sorted
        .withFilter { case Array(_, _, _) => true; case _ => false }
        .foreach { case Array(x, y, idx) =>
          while (q.nonEmpty && x - q.front(0) > mid) {
            val Array(nx, ny, _) = q.dequeue()
            st.remove((ny, nx))
          }
          if (q.nonEmpty) {
            val i = st.range((y - mid, Int.MinValue), (y + mid, Int.MaxValue)).iterator
            if (i.hasNext) found = true
          }
          q.enqueue(Array(x, y, idx))
          st.add((y, x))
        }
      found
    }

    while (l + 1 != r) {
      val mid = (l + r) / 2
      if (check(mid)) r = mid
      else l = mid
    }

    var res = Array(n, n)
    val q = mutable.Queue.empty[Array[Int]]
    val st = mutable.SortedSet.empty[Array[Int]](Ordering.by((a: Array[Int]) => (a(1), a.head)))

    def solve(i: Int, j: Int, res: Array[Int]): Array[Int] = {
      val (newI, newJ) = if (i < j) (i, j) else (j, i)
      if (newI < res(0) || (newI == res(0) && newJ < res(1))) Array(newI, newJ) else res
    }

    sorted
      .withFilter { case Array(_, _, _) => true; case _ => false }
      .foreach { case Array(x, y, i) =>
        while (q.nonEmpty && x - q.front(0) > r) {
          val Array(nx, ny, ni) = q.dequeue()
          st.remove(Array(nx, ny, ni))
        }
        val idx = st.range(Array(y - r, Int.MinValue), Array(y + r, Int.MaxValue)).iterator
        if (idx.hasNext) {
          val ni = idx.next()
          if ((ni(1) - y).abs <= r) res = solve(i, ni(2), res)
        }
        q.enqueue(Array(x, y, i))
        st.add(Array(x, y, i))
      }
    res
  }
}
