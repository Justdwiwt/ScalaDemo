package leetCode._3500

import scala.util.Sorting

object Solution_3414 {
  private case class Tuple(l: Int, r: Int, weight: Int, i: Int)

  private case class Pair(sum: Long, id: List[Int])

  def maximumWeight(intervals: List[List[Int]]): Array[Int] = {
    val n = intervals.length
    val a = intervals.zipWithIndex.map { case (interval, i) =>
      Tuple(interval.head, interval(1), interval(2), i)
    }.toArray

    Sorting.quickSort(a)(Ordering.by(_.r))

    val f = Array.fill(n + 1, 5)(Pair(0L, List.empty[Int]))

    intervals.indices.foreach(i => {
      val t = a(i)
      val k = search(a, i, t.l)
      f(i + 1)(0) = Pair(0L, List.empty[Int])

      (1 to 4).foreach(j => {
        val s1 = f(i)(j).sum
        val s2 = f(k + 1)(j - 1).sum + t.weight.toLong

        f(i + 1)(j) = if (s1 > s2) f(i)(j)
        else {
          val newId = (f(k + 1)(j - 1).id :+ t.i).sorted
          if (s1 == s2 && compareLists(f(i)(j).id, newId) < 0) f(i)(j)
          else Pair(s2, newId)
        }
      })
    })

    f(n)(4).id.toArray
  }

  private def search(a: Array[Tuple], right: Int, upper: Int): Int = {
    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int =
      if (left + 1 >= right) left
      else {
        val mid = (left + right) >>> 1
        if (a(mid).r < upper) binarySearch(mid, right)
        else binarySearch(left, mid)
      }

    binarySearch(-1, right)
  }

  private def compareLists(a: List[Int], b: List[Int]): Int = a
    .zip(b)
    .find { case (x, y) => x != y }
    .map { case (x, y) => x - y }
    .getOrElse(a.length - b.length)
}
