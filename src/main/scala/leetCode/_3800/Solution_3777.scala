package leetCode._3800

object Solution_3777 {
  def minDeletions(s: String, queries: Array[Array[Int]]): Array[Int] = {
    val seg = new SegmentTree(s)

    queries.flatMap {
      case Array(1, i) =>
        seg.flip(i)
        None
      case Array(2, l, r) =>
        Some(seg.query(l, r))
    }
  }

  final case class Data(lc: Int = -1, rc: Int = -1, del: Int = 0)

  final class SegmentTree(s: String) {
    private val n = s.length
    private val t = Array.fill(4 * n)(Data())

    build(1, 0, n - 1)

    private def merge(a: Data, b: Data): Data =
      if (a.lc < 0) b
      else if (b.lc < 0) a
      else
        Data(
          a.lc,
          b.rc,
          a.del + b.del + (if (a.rc == b.lc) 1 else 0)
        )

    private def build(o: Int, l: Int, r: Int): Unit =
      if (l == r) {
        val c = s(l) - 'A'
        t(o) = Data(c, c, 0)
      } else {
        val m = (l + r) >>> 1
        build(o << 1, l, m)
        build(o << 1 | 1, m + 1, r)
        t(o) = merge(t(o << 1), t(o << 1 | 1))
      }

    private def flip(o: Int, l: Int, r: Int, i: Int): Unit =
      if (l == r) {
        val x = t(o).lc ^ 1
        t(o) = Data(x, x, 0)
      } else {
        val m = (l + r) >>> 1
        if (i <= m) flip(o << 1, l, m, i)
        else flip(o << 1 | 1, m + 1, r, i)
        t(o) = merge(t(o << 1), t(o << 1 | 1))
      }

    def flip(i: Int): Unit =
      flip(1, 0, n - 1, i)

    private def query(o: Int, l: Int, r: Int, ql: Int, qr: Int): Data =
      if (ql <= l && r <= qr) t(o)
      else {
        val m = (l + r) >>> 1
        if (qr <= m) query(o << 1, l, m, ql, qr)
        else if (ql > m) query(o << 1 | 1, m + 1, r, ql, qr)
        else merge(
          query(o << 1, l, m, ql, qr),
          query(o << 1 | 1, m + 1, r, ql, qr)
        )
      }

    def query(l: Int, r: Int): Int =
      query(1, 0, n - 1, l, r).del
  }
}
