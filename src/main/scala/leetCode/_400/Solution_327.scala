package leetCode._400

object Solution_327 {
  var lo: Long = 0
  var hi: Long = 0
  private type R = (List[Long], Int, Long)

  def countRangeSum(nums: Array[Int], lower: Int, upper: Int): Int = {
    lo = lower
    hi = upper
    dc(nums, 0, nums.length)._2
  }

  private def dc(nums: Array[Int], start: Int, len: Int): R =
    if (len == 1) {
      val curr = nums(start)
      (List(curr), if (curr >= lo && curr <= hi) 1 else 0, curr)
    } else {
      val n = len / 2
      join(dc(nums, start, n), dc(nums, start + n, len - n))
    }

  private def join(l: R, r: R): R = {
    val _l1 = dropFirst(insertToSortedDesc(l._1, 0L), l._3)
    val _r1 = r._1.map(_ + l._3)
    val v = l._2 + r._2 + Longer(_l1, _r1, lo, hi)
    (mergeSortJoin(Nil, l._1, _r1), v, l._3 + r._3)
  }

  private def Longer(xs: List[Long], ys: List[Long], lo: Long, hi: Long): Int = {
    @scala.annotation.tailrec
    def loop(xs: List[Long], ys: List[Long], lo: Long, lxs: Int, acc: Int): Int = (xs, ys) match {
      case (_, Nil) => acc
      case (Nil, _) => acc
      case (x :: _xs, y :: _ys) => if (y >= x + lo) loop(xs, _ys, lo, lxs, acc + lxs) else loop(_xs, ys, lo, lxs - 1, acc)
    }

    val lxs = xs.length
    loop(xs, ys, lo, lxs, 0) - loop(xs, ys, hi + 1, lxs, 0)
  }

  @scala.annotation.tailrec
  private def mergeSortJoin(acc: List[Long], xs: List[Long], ys: List[Long]): List[Long] = (xs, ys) match {
    case (xs, Nil) => acc.reverse ++ xs
    case (Nil, ys) => acc.reverse ++ ys
    case (x :: _xs, y :: _ys) => if (x > y) mergeSortJoin(x :: acc, _xs, ys) else mergeSortJoin(y :: acc, xs, _ys)
  }

  private def insertToSortedDesc[T: Ordering](list: List[T], elem: T): List[T] = {
    val ord = implicitly[Ordering[T]]
    val (before, after) = list.span(ord.compare(elem, _) < 0)
    before ++ (elem :: after)
  }

  private def dropFirst[T: Ordering](list: List[T], elem: T): List[T] = {
    val ord = implicitly[Ordering[T]]
    val (before, after) = list.span(ord.compare(elem, _) != 0)
    before ++ after.tail
  }
}
