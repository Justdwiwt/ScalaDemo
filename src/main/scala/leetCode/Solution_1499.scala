package leetCode

import scala.collection.mutable

object Solution_1499 {
  def findMaxValueOfEquation(points: Array[Array[Int]], k: Int): Int = {
    val pq = new java.util.PriorityQueue[Array[Int]]((o1: Array[Int], o2: Array[Int]) => o2(0) - o1(0))
    var l = 0
    var r = 1
    var res = Int.MinValue
    while (l < points.length - 1) {
      if (r < points.length && points(r)(0) - points(l)(0) <= k) {
        pq.add(Array(points(r)(1) + points(r)(0), points(r)(0)))
        r += 1
      } else {
        while (!pq.isEmpty && pq.peek()(1) <= points(l)(0)) pq.poll()
        if (!pq.isEmpty) {
          val t = pq.peek()
          res = res.max(t(0) + points(l)(1) - points(l)(0))
        }
        l += 1
        if (l == r) r += 1
      }
    }
    res
  }
}

object Bisect {
  type AB = mutable.ArrayBuffer[Int]

  def insort(ab: AB, x: Int): Unit = insort_right(ab, x)

  def insort_right(ab: AB, x: Int): Unit = ab.insert(bisect(ab, x), x)

  def insort_left(ab: AB, x: Int): Unit = ab.insert(bisect_left(ab, x), x)

  def bisect(ab: AB, x: Int): Int = bisect_right(ab, x)

  def bisect_right(ab: AB, x: Int): Int = bisect_right(ab, x, 0, ab.length)

  def bisect_left(ab: AB, x: Int): Int = bisect_left(ab, x, 0, ab.length)

  def bisect_left(ab: AB, target: Int, l: Int, r: Int): Int =
    if (l >= r) l else {
      val mid = l + (r - l) / 2
      if (ab(mid) < target) bisect_right(ab, target, mid + 1, r)
      else bisect_right(ab, target, l, mid)
    }

  @scala.annotation.tailrec
  def bisect_right(ab: AB, target: Int, l: Int, r: Int): Int =
    if (l >= r) l else {
      val mid = l + (r - l) / 2
      if (ab(mid) <= target) bisect_right(ab, target, mid + 1, r)
      else bisect_right(ab, target, l, mid)
    }

  def remove(ab: AB, x: Int): Unit = {
    val idx = bisect(ab, x) - 1
    if (ab(idx) == x) ab.remove(idx)
  }

  def find(ab: AB, x: Int): Int = {
    val idx = bisect(ab, x) - 1
    if (ab(idx) == x) idx else -1
  }
}

object Solution2 {
  def findMaxValueOfEquation(points: Array[Array[Int]], k: Int): Int = {
    val ab = mutable.ArrayBuffer[Int]()
    var pos = 0
    var ret = -1e9.toInt
    points.indices.foreach(i => points(i) match {
      case Array(xi, yi) =>
        while (pos < i && xi - points(pos)(0) > k) {
          Bisect.remove(ab, points(pos)(1) - points(pos)(0))
          pos += 1
        }
        if (ab.nonEmpty) ret = ret max (xi + yi + ab.last)
        Bisect.insort(ab, -xi + yi)
    })
    ret
  }
}
