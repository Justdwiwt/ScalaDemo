package leetCode._2700

import scala.collection.mutable

object Solution_2613 {
  def beautifulPair(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val n = nums1.length
    val res = Array(n, n)
    val h = mutable.Map.empty[(Int, Int), Int]
    val arr = Array.tabulate(n)(i => (nums1(i), nums2(i), i))

    arr.foreach { case (x, y, i) =>
      h.get((x, y)) match {
        case Some(prevIndex) =>
          val (i0, i1) = (Math.min(prevIndex, i), Math.max(prevIndex, i))
          if (i0 < res.head || (i0 == res.head && i1 < res(1))) {
            res(0) = i0
            res(1) = i1
          }
        case None => h((x, y)) = i
      }
    }

    if (res.head < n && res(1) < n) return res

    val sorted = arr.sortBy { case (x, y, _) => (x, y) }
    var mn = n * 3
    val st = mutable.SortedSet.empty[(Int, Int, Int)](Ordering.by { case (x, y, i) => (y, x, i) })
    var l = 0

    sorted.indices.foreach(i => {
      while (l < i && sorted(i)._1 - sorted(l)._1 > mn) {
        st.remove((sorted(l)._1, sorted(l)._2, sorted(l)._3))
        l += 1
      }
      val idx = st.from((sorted(i)._1, sorted(i)._2 - mn, -1))
      idx.iterator.takeWhile { case (_, sy, _) => sy - sorted(i)._2 <= mn }.foreach { case (sx, sy, si) =>
        val d = (sx - sorted(i)._1).abs + (sy - sorted(i)._2).abs
        val (i0, i1) = (si.min(sorted(i)._3), si.max(sorted(i)._3))
        if (d < mn || (d == mn && (i0 < res.head || (i0 == res.head && i1 < res(1))))) {
          mn = d
          res(0) = i0
          res(1) = i1
        }
      }
      st.add((sorted(i)._1, sorted(i)._2, sorted(i)._3))
    })

    res
  }
}
