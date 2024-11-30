package leetCode._3400

object Solution_3362 {
  private class STree(val n: Int) {
    private val tr: Array[Long] = Array.fill(4 * n)(0L)
    private val v: Array[Long] = Array.fill(4 * n)(0L)

    def build(d: Array[Long], no: Int, l: Int, r: Int): Unit = {
      if (l == r) {
        tr(no) = d(l)
        return
      }
      val mid = (l + r) / 2
      build(d, 2 * no, l, mid)
      build(d, 2 * no + 1, mid + 1, r)
      tr(no) = tr(2 * no).min(tr(2 * no + 1))
    }

    private def pushDown(no: Int, l: Int, r: Int): Unit = {
      if (v(no) != 0) {
        tr(2 * no) += v(no)
        v(2 * no) += v(no)
        tr(2 * no + 1) += v(no)
        v(2 * no + 1) += v(no)
        v(no) = 0
      }
    }

    def _add(no: Int, l: Int, r: Int, ql: Int, qr: Int, value: Long): Unit = {
      if (ql > r || qr < l) return
      if (ql <= l && r <= qr) {
        tr(no) += value
        v(no) += value
        return
      }
      pushDown(no, l, r)
      val mid = (l + r) / 2
      _add(2 * no, l, mid, ql, qr, value)
      _add(2 * no + 1, mid + 1, r, ql, qr, value)
      tr(no) = tr(2 * no).min(tr(2 * no + 1))
    }

    def _min(no: Int, l: Int, r: Int, ql: Int, qr: Int): Long = {
      if (ql > r || qr < l) return Long.MaxValue
      if (ql <= l && r <= qr) return tr(no)
      pushDown(no, l, r)
      val mid = (l + r) / 2
      _min(2 * no, l, mid, ql, qr).min(_min(2 * no + 1, mid + 1, r, ql, qr))
    }
  }

  def maxRemoval(nums: Array[Int], queries: Array[Array[Int]]): Int = {
    val n = nums.length
    val q = queries.length
    val cnt = Array.fill(n)(0)
    val vv = Array.fill(n + 1)(0)

    var i = 0
    while (i < q) {
      val l = queries(i)(0)
      val r = queries(i)(1)
      vv(l) += 1
      if (r + 1 < n) vv(r + 1) -= 1
      i += 1
    }

    cnt(0) = vv(0)
    var j = 1
    while (j < n) {
      cnt(j) = cnt(j - 1) + vv(j)
      j += 1
    }

    val del = Array.fill(n)(0L)
    var k = 0
    while (k < n) {
      del(k) = cnt(k).toLong - nums(k).toLong
      if (del(k) < 0) return -1
      k += 1
    }

    val sortedQueries = queries.sortBy(q => (q(1), q.head))

    val st = new STree(n)
    st.build(del, 1, 0, n - 1)

    var res = 0

    var m = 0
    while (m < sortedQueries.length) {
      val q = sortedQueries(m)
      val l = q.head
      val r = q(1)
      val mn = st._min(1, 0, n - 1, l, r)
      if (mn > 0) {
        res += 1
        st._add(1, 0, n - 1, l, r, -1)
      }
      m += 1
    }

    res
  }
}
