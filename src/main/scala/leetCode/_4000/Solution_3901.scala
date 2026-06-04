package leetCode._4000

object Solution_3901 {
  private final class SegmentTree(nums: Array[Int], p: Int) {
    private val n = nums.length
    private val tree = Array.fill[Int](4 * n)(0)

    @inline
    @scala.annotation.tailrec
    private def gcd(a: Int, b: Int): Int =
      if (b == 0) math.abs(a) else gcd(b, a % b)

    private def build(o: Int, l: Int, r: Int): Unit =
      if (l == r)
        tree(o) = if (nums(l) % p == 0) nums(l) else 0
      else {
        val m = (l + r) >>> 1
        build(o << 1, l, m)
        build(o << 1 | 1, m + 1, r)
        tree(o) = gcd(tree(o << 1), tree(o << 1 | 1))
      }

    build(1, 0, n - 1)

    private def update(o: Int, l: Int, r: Int, i: Int, v: Int): Unit =
      if (l == r)
        tree(o) = if (v % p == 0) v else 0
      else {
        val m = (l + r) >>> 1
        if (i <= m) update(o << 1, l, m, i, v)
        else update(o << 1 | 1, m + 1, r, i, v)

        tree(o) = gcd(tree(o << 1), tree(o << 1 | 1))
      }

    def update(i: Int, v: Int): Unit =
      update(1, 0, n - 1, i, v)

    private def query(o: Int, l: Int, r: Int, ql: Int, qr: Int): Int =
      if (ql > qr) 0
      else if (ql <= l && r <= qr) tree(o)
      else {
        val m = (l + r) >>> 1
        if (qr <= m) query(o << 1, l, m, ql, qr)
        else if (ql > m) query(o << 1 | 1, m + 1, r, ql, qr)
        else
          gcd(
            query(o << 1, l, m, ql, qr),
            query(o << 1 | 1, m + 1, r, ql, qr)
          )
      }

    def query(l: Int, r: Int): Int =
      query(1, 0, n - 1, l, r)

    def queryAll(): Int = tree(1)

    def check(): Boolean =
      (0 until n).exists(i => gcd(query(0, i - 1), query(i + 1, n - 1)) == p)
  }

  def countGoodSubseq(nums: Array[Int], p: Int, queries: Array[Array[Int]]): Int = {
    val seg = new SegmentTree(nums, p)
    var cntP = nums.count(_ % p == 0)

    queries.foldLeft(0)((ans, q) => {
      val i = q(0)
      val x = q(1)

      if (nums(i) % p == 0) cntP -= 1
      if (x % p == 0) cntP += 1

      nums(i) = x
      seg.update(i, x)

      if (seg.queryAll() == p && (cntP < nums.length || nums.length > 6 || seg.check())) ans + 1
      else ans
    })
  }
}
