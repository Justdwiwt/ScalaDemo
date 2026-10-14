package leetCode._4100

object Solution_4017 {
  def countOfPeaks(nums: Array[Int], queries: Array[Array[Int]]): Array[Long] = {
    val n = nums.length
    val arr = nums.clone()
    val bit = Array.fill(n + 1)(0L)
    val peaks = new java.util.TreeSet[Integer]()

    def bitUpd(i: Int, d: Long): Unit = Iterator
      .iterate(i + 1)(x => x + (x & -x))
      .takeWhile(_ <= n)
      .foreach(bit(_) += d)

    def bitQ(i: Int): Long = Iterator
      .iterate(i + 1)(x => x - (x & -x))
      .takeWhile(_ > 0)
      .map(bit)
      .sum

    def bitR(l: Int, r: Int): Long =
      if (l > r) 0L
      else bitQ(r) - (if (l == 0) 0L else bitQ(l - 1))

    def isPeak(i: Int): Boolean =
      i > 0 && i < n - 1 && arr(i) > arr(i - 1) && arr(i) > arr(i + 1)

    def gp(p: Int): Int =
      Option(peaks.lower(p: Integer)).fold(0)(_.intValue())

    def addP(p: Int): Unit =
      if (!peaks.contains(p: Integer)) {
        val prev = gp(p)
        Option(peaks.higher(p: Integer)).foreach(hi => bitUpd(hi.intValue(), hi.longValue() * (prev.toLong - p)))
        peaks.add(p: Integer)
        bitUpd(p, p.toLong * (p - prev))
      }

    def remP(p: Int): Unit =
      if (peaks.contains(p: Integer)) {
        val prev = gp(p)
        Option(peaks.higher(p: Integer)).foreach(hi => bitUpd(hi.intValue(), hi.longValue() * (p.toLong - prev)))
        bitUpd(p, -p.toLong * (p - prev))
        peaks.remove(p: Integer)
      }

    nums.indices.drop(1).dropRight(1).filter(isPeak).foreach(addP)

    queries.flatMap {
      case Array(1, l, r) =>
        val a = Option(peaks.higher(l: Integer)).map(_.intValue())
        val b = Option(peaks.lower(r: Integer)).map(_.intValue())

        Array(a.flatMap(x => b
          .withFilter(x <= _)
          .map { y => val q = gp(x); (y, q) }
          .map { case (y, q) => val w = bitR(x, y); (y, q, w) }
          .map { case (y, q, w) => r.toLong * (y - l) - w + x.toLong * (l - q) }
        ).getOrElse(0L))

      case Array(2, idx, v) =>
        val affected = 1.max(idx - 1) to (n - 2).min(idx + 1)
        affected.foreach(remP)
        arr(idx) = v
        affected.filter(isPeak).foreach(addP)
        Array.emptyLongArray
    }
  }
}
