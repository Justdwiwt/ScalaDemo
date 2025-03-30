package leetCode._3500

object Solution_3454 {
  private case class Event(y: Int, lx: Int, rx: Int, delta: Int)

  private case class Record(area: Long, sumLen: Int)

  def separateSquares(squares: Array[Array[Int]]): Double = {
    val nEvents = squares.length * 2
    val xs = new Array[Int](nEvents)
    val events = new Array[Event](nEvents)
    var idx = 0
    squares.foreach(sq => {
      val lx = sq.head
      val y = sq(1)
      val l = sq(2)
      val rx = lx + l
      xs(idx) = lx
      xs(idx + 1) = rx
      events(idx) = Event(y, lx, rx, 1)
      events(idx + 1) = Event(y + l, lx, rx, -1)
      idx += 2
    })

    java.util.Arrays.sort(xs)

    val segTree = new SegmentTree(xs)

    java.util.Arrays.sort(events, (a: Event, b: Event) => a.y - b.y)

    val records = new Array[Record](nEvents - 1)
    var totArea = 0L
    (0 until nEvents - 1).foreach(i => {
      val e = events(i)
      val l = java.util.Arrays.binarySearch(xs, e.lx)
      val r = java.util.Arrays.binarySearch(xs, e.rx) - 1
      segTree.update(l, r, e.delta)
      val sumLen = xs(xs.length - 1) - xs(0) - segTree.getUncoveredLength
      records(i) = Record(totArea, sumLen)
      totArea += sumLen.toLong * (events(i + 1).y - e.y)
    })

    var i = 0
    while (i < nEvents - 1 && records(i).area * 2 < totArea)
      i += 1
    i -= 1
    events(i).y + (totArea - records(i).area * 2) / (records(i).sumLen * 2.0)
  }

  private class SegmentTree(xs: Array[Int]) {
    private val n: Int = xs.length - 1
    private val size: Int = 2 << (32 - Integer.numberOfLeadingZeros(n - 1))
    private val minCoverLen: Array[Int] = Array.ofDim[Int](size)
    private val minCover: Array[Int] = Array.ofDim[Int](size)
    private val todo: Array[Int] = Array.ofDim[Int](size)

    build(xs, 1, 0, n - 1)

    def update(l: Int, r: Int, v: Int): Unit = {
      update(1, 0, n - 1, l, r, v)
    }

    def getUncoveredLength: Int = {
      if (minCover(1) == 0) minCoverLen(1) else 0
    }

    private def maintain(o: Int): Unit = {
      val mn = math.min(minCover(o * 2), minCover(o * 2 + 1))
      minCover(o) = mn
      minCoverLen(o) =
        (if (minCover(o * 2) == mn) minCoverLen(o * 2) else 0) +
          (if (minCover(o * 2 + 1) == mn) minCoverLen(o * 2 + 1) else 0)
    }

    private def do_(o: Int, v: Int): Unit = {
      minCover(o) += v
      todo(o) += v
    }

    private def spread(o: Int): Unit = {
      if (todo(o) != 0) {
        do_(o * 2, todo(o))
        do_(o * 2 + 1, todo(o))
        todo(o) = 0
      }
    }

    private def build(xs: Array[Int], o: Int, l: Int, r: Int): Unit =
      if (l == r) minCoverLen(o) = xs(l + 1) - xs(l)
      else {
        val m = (l + r) / 2
        build(xs, o * 2, l, m)
        build(xs, o * 2 + 1, m + 1, r)
        maintain(o)
      }

    private def update(o: Int, l: Int, r: Int, ql: Int, qr: Int, v: Int): Unit =
      if (ql <= l && r <= qr) do_(o, v)
      else {
        spread(o)
        val m = (l + r) / 2
        if (ql <= m) update(o * 2, l, m, ql, qr, v)
        if (m < qr) update(o * 2 + 1, m + 1, r, ql, qr, v)
        maintain(o)
      }
  }
}
