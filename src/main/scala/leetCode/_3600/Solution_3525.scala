package leetCode._3600

object Solution_3525 {
  def resultArray(nums: Array[Int], k: Int, queries: Array[Array[Int]]): Array[Int] = {
    val t = new SegmentTree(nums, k)
    val n = nums.length
    val ans = Array.ofDim[Int](queries.length)
    queries.indices.foreach(qi => {
      val q = queries(qi)
      t.update(q.head, q(1))
      ans(qi) = t.query(q(2), n - 1, q(3))
    })
    ans
  }
}

class SegmentTree(a: Array[Int], k: Int) {
  case class Data(mul: Int, cnt: Array[Int])

  private val n = a.length
  private val size = 2 << (32 - Integer.numberOfLeadingZeros(n - 1))
  private val tree = new Array[Data](size)

  private def mergeData(a: Data, b: Data): Data = {
    val cnt = a.cnt.clone()
    (0 until k).foreach(rx => {
      val idx = a.mul * rx % k
      cnt(idx) += b.cnt(rx)
    })
    Data(a.mul * b.mul % k, cnt)
  }

  private def newData(value: Int): Data = {
    val mul = value % k
    val cnt = Array.fill(k)(0)
    cnt(mul) = 1
    Data(mul, cnt)
  }

  private def build(a: Array[Int], node: Int, l: Int, r: Int): Unit =
    if (l == r) tree(node) = newData(a(l))
    else {
      val m = (l + r) / 2
      build(a, node * 2, l, m)
      build(a, node * 2 + 1, m + 1, r)
      maintain(node)
    }

  private def maintain(node: Int): Unit =
    tree(node) = mergeData(tree(node * 2), tree(node * 2 + 1))

  private def update(node: Int, l: Int, r: Int, i: Int, value: Int): Unit =
    if (l == r) tree(node) = newData(value)
    else {
      val m = (l + r) / 2
      if (i <= m) update(node * 2, l, m, i, value)
      else update(node * 2 + 1, m + 1, r, i, value)
      maintain(node)
    }

  private def query(node: Int, l: Int, r: Int, ql: Int, qr: Int): Data =
    if (ql <= l && r <= qr) tree(node)
    else {
      val m = (l + r) / 2
      if (qr <= m) query(node * 2, l, m, ql, qr)
      else if (ql > m) query(node * 2 + 1, m + 1, r, ql, qr)
      else {
        val left = query(node * 2, l, m, ql, qr)
        val right = query(node * 2 + 1, m + 1, r, ql, qr)
        mergeData(left, right)
      }
    }

  build(a, 1, 0, n - 1)

  def update(i: Int, value: Int): Unit =
    update(1, 0, n - 1, i, value)

  def query(ql: Int, qr: Int, x: Int): Int =
    query(1, 0, n - 1, ql, qr).cnt(x)
}
